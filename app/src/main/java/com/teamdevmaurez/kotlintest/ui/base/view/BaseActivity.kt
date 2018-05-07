package com.teamdevmaurez.kotlintest.ui.base.view

import android.os.Bundle
import android.support.design.R.id.snackbar_text
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.CallBack {

    private var snackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideSnackBar() {
        snackbar?.let { if (it.isShown) it.dismiss() }
    }

    override fun showSnackBar(message: Int) {
        hideSnackBar()

        snackbar = Snackbar.make(main_CoordinatorLayout, getString(message), Snackbar.LENGTH_LONG)
        snackbar?.show()
    }

    override fun showError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun performDI() = AndroidInjection.inject(this)

}