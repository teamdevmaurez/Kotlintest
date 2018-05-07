package com.teamdevmaurez.kotlintest.ui.mangaslist.presenter

import com.teamdevmaurez.kotlintest.ui.base.presenter.MVPPresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasMVPInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasMVPView


interface MangasMVPPresenter<V : MangasMVPView, I : MangasMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
    fun onDestroyView()
}