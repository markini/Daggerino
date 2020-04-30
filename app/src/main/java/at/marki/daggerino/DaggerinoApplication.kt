package at.marki.daggerino

import android.app.Application
import at.marki.daggerino.app.BuildConfig.DEBUG
import at.marki.daggerino.tools.CrashReportingTree
import timber.log.Timber
import timber.log.Timber.DebugTree

@Suppress("unused")
class DaggerinoApplication : Application() {

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
}
