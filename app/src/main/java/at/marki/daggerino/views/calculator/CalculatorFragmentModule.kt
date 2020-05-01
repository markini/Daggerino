package at.marki.daggerino.views.calculator

import dagger.Binds
import dagger.Module

@Module
abstract class CalculatorFragmentModule {
    @Binds
    abstract fun calculatorFragment(calculator: CalculatorFragment): CalculatorView
}
