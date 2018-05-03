package com.teamdevmaurez.kotlintest.ui.mangaslist.presenter

import com.teamdevmaurez.kotlintest.ui.base.presenter.BasePresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasMVPInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasMVPView
import com.teamdevmaurez.kotlintest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
class MangasPresenter<V : MangasMVPView, I : MangasMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) :
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable),
        MangasMVPPresenter<V, I> {

    companion object {

        const val TIMEOUT = 100.toLong()
    }

    var disposable: Disposable? = null

    override fun onViewPrepared() {
        getView()?.showProgress()

        disposable =  interactor?.let {
             it.getMangaList()
                    .debounce(TIMEOUT, TimeUnit.MILLISECONDS)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .onErrorReturn {
                        Timber.d("onViewPrepared:onErrorReturn ${it} ")

                         listOf()
                    }
                    .subscribe { mangas ->
                        getView()?.let {
                            it.showEmptylist()
                            it.hideProgress()
                            it.displayMangaList(mangas)
                        }
                    }
        }
    }

    override fun onDestroyView() {
        disposable?.dispose()
    }
}