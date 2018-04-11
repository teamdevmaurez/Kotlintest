package com.teamdevmaurez.kotlintest.ui.main.presenter

import com.teamdevmaurez.kotlintest.ui.base.presenter.MVPPresenter
import com.teamdevmaurez.kotlintest.ui.main.interactor.MainMVPInteractor
import com.teamdevmaurez.kotlintest.ui.main.view.MainMVPView

/**
 * Created by teamdevmaurez on 15/03/2018.
 */
interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

    fun onDrawerMangasGalleryClick(): Unit?

}