package at.marki.daggerino.views.main

import at.marki.daggerino.views.calculator.CalculatorFragment
import at.marki.daggerino.views.calculator.CalculatorFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {
//    @Binds
//    abstract fun bindMainActivityView(mainActivity: MainActivity?): MainActivityView?

    @ContributesAndroidInjector(modules = [CalculatorFragmentModule::class])
    abstract fun calculatorFragmentInjector(): CalculatorFragment
}
