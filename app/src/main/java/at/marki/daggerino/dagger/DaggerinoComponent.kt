package at.marki.daggerino.dagger

import at.marki.daggerino.DaggerinoApplication
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [DaggerinoModule::class])
interface DaggerinoComponent : AndroidInjector<DaggerinoApplication> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<DaggerinoApplication>

//    @Component.Factory
//    interface Factory : AndroidInjector.Factory<DaggerinoApplication> {
//        override fun create(@BindsInstance instance: DaggerinoApplication): DaggerinoComponent
//    }
}
