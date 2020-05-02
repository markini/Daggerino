package at.marki.daggerino.worker

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import at.marki.daggerino.tools.TimeLogger
import timber.log.Timber
import javax.inject.Inject

class Worker2(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    init {
        //Inject the worker
        AndroidWorkerInjection.inject(this)
    }

    @Inject
    lateinit var timeLogger: TimeLogger

    override fun doWork(): Result {
        Timber.e("Worker 2 Running")
        timeLogger.logCurrentTime()
        return Result.success()
    }

    companion object {
        fun startWorker(context: Context?) {
            if (context == null) return
            val worker1Request = OneTimeWorkRequestBuilder<Worker2>().build()
            WorkManager.getInstance(context).enqueue(worker1Request)
        }
    }
}
