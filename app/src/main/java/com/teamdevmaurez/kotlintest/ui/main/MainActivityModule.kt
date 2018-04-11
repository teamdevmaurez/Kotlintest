package com.teamdevmaurez.kotlintest.ui.main

import com.teamdevmaurez.kotlintest.ui.main.interactor.MainInteractor
import com.teamdevmaurez.kotlintest.ui.main.interactor.MainMVPInteractor
import com.teamdevmaurez.kotlintest.ui.main.presenter.MainMVPPresenter
import com.teamdevmaurez.kotlintest.ui.main.presenter.MainPresenter
import com.teamdevmaurez.kotlintest.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>): MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}