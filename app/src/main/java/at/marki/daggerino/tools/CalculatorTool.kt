package at.marki.daggerino.tools

import android.content.Context
import android.view.View
import at.marki.daggerino.tools.SnackCreator1
import dagger.android.HasAndroidInjector
import javax.inject.Inject

// TestClass to showcase how to inject into it. This class just calls the SnackCreator1.
class CalculatorTool(appContext: Context) {

    @Inject
    lateinit var snackCreator1: SnackCreator1

    init {
        val injector = appContext.applicationContext as HasAndroidInjector
        injector.androidInjector().inject(this)
    }

    fun createSnackText(view: View, text: String) {
        snackCreator1.showMessageSnackbar(view, text)
    }
}
