package at.marki.daggerino.tools

import android.view.View
import com.google.android.material.snackbar.Snackbar

class SnackCreator2 constructor(debug: Boolean = false) {

    private val preText = if (debug) "DebugCreator2" else "Creator2"

    fun showMessageSnackbar(view: View, text: String) {
        val snackbar = Snackbar.make(view, "$preText $text", Snackbar.LENGTH_LONG)
        snackbar.isGestureInsetBottomIgnored = true
        snackbar.show()
    }
}
