package com.teamdevmaurez.kotlintest.ui.mangaslist.presenter

import com.teamdevmaurez.kotlintest.ui.base.presenter.BasePresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasMVPInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasMVPView
import com.teamdevmaurez.kotlintest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
class MangasPresenter<V : MangasMVPView, I : MangasMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) :
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable),
        MangasMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.getMangaList()
                    .debounce(400, TimeUnit.MILLISECONDS)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { mangas ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayMangaList(mangas)
                        }
                    }
        }
    }
}