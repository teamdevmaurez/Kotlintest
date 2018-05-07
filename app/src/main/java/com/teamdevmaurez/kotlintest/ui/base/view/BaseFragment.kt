package com.teamdevmaurez.kotlintest.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment(), BaseView {

    private var parentActivity: BaseActivity? = null


    /************* Fragment IMPL **************/

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


    /************* BaseView IMPL **************/

    override fun hideSnackBar() {
        parentActivity?.hideSnackBar()
    }

    override fun showSnackBar(message: Int) {
        parentActivity?.showSnackBar(message)
    }

    override fun showError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached(tag: String?)
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()
}