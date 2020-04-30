package at.marki.daggerino

import at.marki.daggerino.BuildConfig.DEBUG
import at.marki.daggerino.dagger.DaggerDaggerinoComponent
import at.marki.daggerino.dagger.DaggerinoComponent
import at.marki.daggerino.tools.CrashReportingTree
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import timber.log.Timber
import timber.log.Timber.DebugTree

@Suppress("unused")
class DaggerinoApplication : DaggerApplication(), HasAndroidInjector {

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
}
