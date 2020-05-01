package at.marki.daggerino.tools

import android.view.View
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SnackCreator1 @Inject constructor() {
    fun showMessageSnackbar(view: View, text: String) {
        val snackbar = Snackbar.make(view, "Creator1 $text", Snackbar.LENGTH_LONG)
        snackbar.isGestureInsetBottomIgnored = true
        snackbar.show()
    }
}
