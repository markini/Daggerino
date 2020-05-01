package at.marki.daggerino.views.calculator

import at.marki.daggerino.DaggerinoApplication
import at.marki.daggerino.library.FactorialCalculator
import javax.inject.Inject

class CalculatorPresenter @Inject constructor(
    private val application: DaggerinoApplication,
    private val callback: CalculatorView
) {

    fun computeFactorial(input: String?): String {
        val errorString = "Error :-("
        if (input.isNullOrBlank()) {
            return errorString
        }
        val number = input.toIntOrNull() ?: return errorString
        return FactorialCalculator.computeFactorial(number).toString()
    }
}
