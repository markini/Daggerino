package at.marki.daggerino.views.calculator

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import at.marki.daggerino.DaggerinoApplication
import at.marki.daggerino.R
import at.marki.daggerino.databinding.FragmentCalculatorBinding
import at.marki.daggerino.events.CalculateEvent
import at.marki.daggerino.tools.SnackCreator1
import at.marki.daggerino.tools.SnackCreator2
import at.marki.daggerino.views.BaseFragment
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class CalculatorFragment : BaseFragment(R.layout.fragment_calculator), CalculatorView {

    @Inject
    lateinit var snackCreator1: SnackCreator1
    @Inject
    lateinit var snackCreator2: SnackCreator2
    @Inject
    lateinit var application: DaggerinoApplication
    @Inject
    lateinit var calculatorPresenter: CalculatorPresenter
    @Inject
    lateinit var bus: EventBus

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var binding: FragmentCalculatorBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Is this a hack? Maybe. I rike iit!
        presenter = calculatorPresenter
    }

    override fun onViewCreated(view: View, inState: Bundle?) {
        super.onViewCreated(view, inState)
        val fragmentCalculatorBinding = FragmentCalculatorBinding.bind(view)
        binding = fragmentCalculatorBinding

        binding?.btnCompute?.setOnClickListener {
            val input = binding?.etFactorial?.text.toString()
            val result = calculatorPresenter.computeFactorial(input)
            binding?.tvResult?.text = result
            binding?.tvResult?.visibility = VISIBLE
            bus.post(CalculateEvent())
        }

        binding?.btnSnack1?.setOnClickListener { snack1Click() }
        binding?.btnSnack2?.setOnClickListener { snack2Click() }
    }

    private fun snack1Click() {
        snackCreator1.showMessageSnackbar(view!!, "Snack 1 Click")
    }

    private fun snack2Click() {
        snackCreator2.showMessageSnackbar(view!!, "Snack 2 Click")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        fun newInstance(): CalculatorFragment {
            return CalculatorFragment()
        }
    }

    override fun showMessage(message: String) {
        snackCreator1.showMessageSnackbar(view!!, message)
    }
}
