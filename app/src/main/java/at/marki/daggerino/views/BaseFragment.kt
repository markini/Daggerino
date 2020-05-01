package at.marki.daggerino.views

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment(@LayoutRes id: Int) : Fragment(id) {

    lateinit var presenter: BasePresenter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        presenter.register()
    }

    override fun onDestroyView() {
        presenter.unregister()
        super.onDestroyView()
    }
}
