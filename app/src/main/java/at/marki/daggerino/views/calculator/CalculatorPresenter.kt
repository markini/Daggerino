package at.marki.daggerino.views.calculator

import at.marki.daggerino.DaggerinoApplication
import at.marki.daggerino.events.CalculateEvent
import at.marki.daggerino.library.FactorialCalculator
import at.marki.daggerino.views.BasePresenter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode.MAIN
import javax.inject.Inject


class CalculatorPresenter @Inject constructor(
    private val application: DaggerinoApplication,
    private val callback: CalculatorView
) : BasePresenter() {

    fun computeFactorial(input: String?): String {
        val errorString = "Error :-("
        if (input.isNullOrBlank()) {
            return errorString
        }
        val number = input.toIntOrNull() ?: return errorString
        return FactorialCalculator.computeFactorial(number).toString()
    }

    @Subscribe(threadMode = MAIN)
    fun onMessageEvent(event: CalculateEvent) {
        callback.showMessage("Calculate Event!")
    }

}
