package at.marki.daggerino.dagger

import android.app.Application
import at.marki.daggerino.DaggerinoApplication
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

// TODO add workermodule
@Module(includes = [AndroidSupportInjectionModule::class])
abstract class DaggerinoModule {
    @Binds
    abstract fun application(app: DaggerinoApplication): Application

//    @Binds
//    abstract fun applicationContext(context: DaggerinoApplication): Context

//    @ContributesAndroidInjector
//    abstract fun downloadWorker(): DownloadWorker?
}
