package com.teamdevmaurez.kotlintest.ui.base.view


interface BaseView {
    fun showError(e: Throwable)

    fun showSnackBar(message: Int)

    fun hideSnackBar()
}