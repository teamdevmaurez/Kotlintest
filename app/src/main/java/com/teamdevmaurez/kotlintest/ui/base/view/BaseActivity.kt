package com.teamdevmaurez.kotlintest.ui.base.view

import android.os.Bundle
import android.support.design.R.id.snackbar_text
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.ProgressBar
import com.teamdevmaurez.kotlintest.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by teamdevmaurez on 22/03/2018.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.CallBack {

    private var snackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        snackbar?.let { if (it.isShown) it.dismiss() }
    }

    override fun showProgress() {
        hideProgress()
        snackbar = Snackbar.make(main_CoordinatorLayout, getString(R.string.SnackBar_text_loading), Snackbar.LENGTH_LONG)
        val contentLay: ViewGroup = snackbar?.view?.findViewById<ViewGroup>(snackbar_text)?.getParent() as ViewGroup
        val item = ProgressBar(this)
        contentLay.addView(item)
    }

    override fun showError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun performDI() = AndroidInjection.inject(this)

}