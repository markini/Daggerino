package at.marki.daggerino.dagger

import at.marki.daggerino.tools.SnackCreator2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    internal fun provideSnackCreator2(): SnackCreator2 {
        return SnackCreator2(false)
    }
}
