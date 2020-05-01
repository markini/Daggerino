package at.marki.daggerino.dagger

import at.marki.daggerino.views.main.MainActivity
import at.marki.daggerino.views.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity?
}
