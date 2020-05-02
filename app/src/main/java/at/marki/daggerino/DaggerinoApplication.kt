package at.marki.daggerino

import androidx.work.Worker
import at.marki.daggerino.BuildConfig.DEBUG
import at.marki.daggerino.dagger.DaggerDaggerinoComponent
import at.marki.daggerino.tools.CrashReportingTree
import at.marki.daggerino.worker.HasWorkerInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject

@Suppress("unused")
class DaggerinoApplication : DaggerApplication(), HasAndroidInjector, HasWorkerInjector {

    @Inject
    lateinit var workerDispatchingAndroidInjector: DispatchingAndroidInjector<Worker>

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

        Timber.d("Start Daggerino Application")
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerDaggerinoComponent.factory().create(this)
    }

    override fun workerInjector(): AndroidInjector<Worker> {
        return workerDispatchingAndroidInjector
    }
}
