package com.teamdevmaurez.kotlintest.ui.base.presenter

import com.teamdevmaurez.kotlintest.ui.base.interactor.MVPInteractor
import com.teamdevmaurez.kotlintest.ui.base.view.BaseView

interface MVPPresenter<V : BaseView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}