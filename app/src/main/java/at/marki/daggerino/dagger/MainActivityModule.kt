package at.marki.daggerino.dagger

import at.marki.daggerino.views.calculator.CalculatorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {
//    @Binds
//    abstract fun bindMainActivityView(mainActivity: MainActivity?): MainActivityView?

    @ContributesAndroidInjector(modules = [CalculatorFragment::class])
    abstract fun calculateFragmentInjector(): CalculatorFragment?
}
