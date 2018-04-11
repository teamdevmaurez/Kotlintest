package com.teamdevmaurez.kotlintest.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teamdevmaurez.kotlintest.util.CommonUtil
import dagger.android.AndroidInjection

/**
 * Created by teamdevmaurez on 22/03/2018.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun showError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun performDI() = AndroidInjection.inject(this)

}