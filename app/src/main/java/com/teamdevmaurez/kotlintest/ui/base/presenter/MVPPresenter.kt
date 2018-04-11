package com.teamdevmaurez.kotlintest.ui.base.presenter

import com.teamdevmaurez.kotlintest.ui.base.interactor.MVPInteractor
import com.teamdevmaurez.kotlintest.ui.base.view.BaseView

/**
 * Created by teamdevmaurez on 22/03/2018.
 */
interface MVPPresenter<V : BaseView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}