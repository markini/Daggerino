package at.marki.daggerino.worker

import androidx.work.Worker
import dagger.android.AndroidInjector
import dagger.internal.Preconditions

object AndroidWorkerInjection {
    fun inject(worker: Worker) {
        Preconditions.checkNotNull(worker, "worker")
        val application: Any = worker.applicationContext
        if (application !is HasWorkerInjector) {
            throw RuntimeException(
                String.format(
                    "%s does not implement %s",
                    application.javaClass.canonicalName,
                    HasWorkerInjector::class.java.getCanonicalName()
                )
            )
        }
        val workerInjector: AndroidInjector<Worker> =
            (application as HasWorkerInjector).workerInjector()

        Preconditions.checkNotNull(
            workerInjector,
            "${application.javaClass}.workerInjector() returned null"
        )
        workerInjector.inject(worker)
    }
}
