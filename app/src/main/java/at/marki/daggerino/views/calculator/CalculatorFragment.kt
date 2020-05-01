package at.marki.daggerino.views.calculator

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import at.marki.daggerino.R
import at.marki.daggerino.databinding.FragmentCalculatorBinding
import at.marki.daggerino.library.FactorialCalculator
import at.marki.daggerino.library.android.NotificationUtil
import at.marki.daggerino.tools.SnackCreator1
import at.marki.daggerino.views.BaseFragment
import javax.inject.Inject

class CalculatorFragment : BaseFragment(R.layout.fragment_calculator) {

    @Inject
    lateinit var snackCreator1: SnackCreator1

    private val notificationUtil: NotificationUtil by lazy {
        NotificationUtil(
            context!!
        )
    }

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var binding: FragmentCalculatorBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, inState: Bundle?) {
        super.onViewCreated(view, inState)
        val fragmentCalculatorBinding = FragmentCalculatorBinding.bind(view)
        binding = fragmentCalculatorBinding

        binding?.btnCompute?.setOnClickListener {
            snackCreator1.showMessageSnackbar(getView()!!, "AAAAHHHHHHH!!!")
            val input = binding?.etFactorial?.text.toString()
            val number = if (input.isBlank()) 0 else input.toInt()
            val result = FactorialCalculator.computeFactorial(number).toString()

            binding?.tvResult?.text = result
            binding?.tvResult?.visibility = VISIBLE

            notificationUtil.showNotification(
                context = context!!,
                title = getString(R.string.notification_title),
                message = result
            )
        }
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
}
