package at.marki.daggerino.views.calculator

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import at.marki.daggerino.R
import at.marki.daggerino.library.FactorialCalculator
import at.marki.daggerino.library.android.NotificationUtil
import at.marki.daggerino.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_calculator.*

class CalculatorFragment : BaseFragment(R.layout.fragment_calculator) {

    private val notificationUtil: NotificationUtil by lazy {
        NotificationUtil(
            context!!
        )
    }

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    // private var binding: FragmentCalculatorBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, inState: Bundle?) {
        super.onViewCreated(view, inState)
//        val fragmentCalculatorBinding = FragmentCalculatorBinding.bind(view)
//        binding = fragmentCalculatorBinding

        btn_compute.setOnClickListener {
            val input = et_factorial.text.toString().toInt()
            val result = FactorialCalculator.computeFactorial(input).toString()

            tv_result.text = result
            tv_result.visibility = VISIBLE

            notificationUtil.showNotification(
                context = context!!,
                title = getString(R.string.notification_title),
                message = result
            )
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        // binding = null
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
