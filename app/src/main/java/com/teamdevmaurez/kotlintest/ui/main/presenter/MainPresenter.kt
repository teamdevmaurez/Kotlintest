package com.teamdevmaurez.kotlintest.ui.main.presenter

import com.teamdevmaurez.kotlintest.ui.base.presenter.BasePresenter
import com.teamdevmaurez.kotlintest.ui.main.interactor.MainMVPInteractor
import com.teamdevmaurez.kotlintest.ui.main.view.MainMVPView
import com.teamdevmaurez.kotlintest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 15/03/2018.
 */
class MainPresenter<V : MainMVPView, I : MainMVPInteractor>
@Inject
internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun onDrawerMangasGalleryClick() {
        getView()?.openMangaGalleryFragment()
    }


}