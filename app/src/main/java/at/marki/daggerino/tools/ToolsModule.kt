package at.marki.daggerino.tools

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ToolsModule {
    @ContributesAndroidInjector
    abstract fun calculatorTool(): CalculatorTool
}
