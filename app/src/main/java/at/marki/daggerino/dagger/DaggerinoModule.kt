package at.marki.daggerino.dagger

import android.app.Application
import android.content.Context
import at.marki.daggerino.DaggerinoApplication
import at.marki.daggerino.Worker1
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

// TODO add workermodule
@Module(includes = [AndroidSupportInjectionModule::class, ActivityModule::class, DataModule::class])
abstract class DaggerinoModule {
    @Binds
    abstract fun application(app: DaggerinoApplication): Application

    @Binds
    abstract fun applicationContext(context: DaggerinoApplication): Context

    @ContributesAndroidInjector
    abstract fun worker1(): Worker1

//    @ContributesAndroidInjector
//    abstract fun downloadWorker(): DownloadWorker?
}
