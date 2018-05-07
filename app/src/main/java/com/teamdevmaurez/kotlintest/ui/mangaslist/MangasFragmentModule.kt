package com.teamdevmaurez.kotlintest.ui.mangaslist

import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasMVPInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.presenter.MangasMVPPresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.presenter.MangasPresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasFragment
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasGalleryAdapter
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasMVPView
import com.teamdevmaurez.kotlintest.util.PreCachingLayoutManager
import dagger.Module
import dagger.Provides


@Module
class MangasFragmentModule {

    @Provides
    internal fun provideMangasInteractor(interactor: MangasInteractor): MangasMVPInteractor = interactor

    @Provides
    internal fun provideMangaPresenter(presenter: MangasPresenter<MangasMVPView, MangasMVPInteractor>): MangasMVPPresenter<MangasMVPView, MangasMVPInteractor> = presenter

    @Provides
    internal fun provideMangasAdapter(): MangasGalleryAdapter = MangasGalleryAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: MangasFragment): PreCachingLayoutManager = PreCachingLayoutManager(fragment.activity!!)

}