package com.teamdevmaurez.kotlintest.ui.base.view

/**
 * Created by teamdevmaurez on 22/03/2018.
 */
interface BaseView {
    fun showError(e: Throwable)

    fun showProgress()

    fun hideProgress()
}