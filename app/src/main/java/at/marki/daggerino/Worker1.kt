package at.marki.daggerino

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import at.marki.daggerino.tools.TimeLogger
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class Worker1(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    init {
        val injector = appContext.applicationContext as HasAndroidInjector
        injector.androidInjector().inject(this)
    }

    @Inject
    lateinit var timeLogger: TimeLogger

    override fun doWork(): Result {
        timeLogger.logCurrentTime()
        return Result.success()
    }

    companion object {
        fun startWorker(context: Context?) {
            if (context == null) return
            val worker1Request = OneTimeWorkRequestBuilder<Worker1>().build()
            WorkManager.getInstance(context).enqueue(worker1Request)
        }
    }
}
