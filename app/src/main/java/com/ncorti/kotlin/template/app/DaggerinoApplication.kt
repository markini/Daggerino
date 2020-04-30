package com.ncorti.kotlin.template.app

import android.app.Application
import at.marki.daggerino.app.BuildConfig
import com.ncorti.kotlin.template.app.tools.CrashReportingTree
import timber.log.Timber
import timber.log.Timber.DebugTree

@Suppress("unused")
class DaggerinoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

        Timber.d("Start Daggerino Application")
    }
}
