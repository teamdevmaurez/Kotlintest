package com.teamdevmaurez.kotlintest.ui.base.presenter

import com.teamdevmaurez.kotlintest.ui.base.interactor.MVPInteractor
import com.teamdevmaurez.kotlintest.ui.base.view.BaseView
import com.teamdevmaurez.kotlintest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by teamdevmaurez on 22/03/2018.
 */
abstract class BasePresenter<V : BaseView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}