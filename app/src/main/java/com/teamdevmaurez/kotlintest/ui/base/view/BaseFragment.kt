package com.teamdevmaurez.kotlintest.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.teamdevmaurez.kotlintest.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
abstract class BaseFragment : Fragment(), BaseView {

    private var parentActivity: BaseActivity? = null
    private var snackbar: Snackbar? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached(tag)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun hideProgress() {
        //snackbar?.let { if (it.isShown) it.dismiss() }
    }

    override fun showProgress() {
        hideProgress()

        var coordinatorLayout: CoordinatorLayout = parentActivity?.main_CoordinatorLayout!!
        snackbar = Snackbar.make(coordinatorLayout, getString(R.string.SnackBar_text_loading), Snackbar.LENGTH_LONG)
        val snackbarLayout = snackbar?.view
        val contentLay = snackbarLayout?.findViewById<View>(android.support.design.R.id.snackbar_text)?.parent as ViewGroup
        val item = ProgressBar(parentActivity)
        contentLay.addView(item)
        snackbar?.show()
    }

    override fun showError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached(tag: String?)
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()
}