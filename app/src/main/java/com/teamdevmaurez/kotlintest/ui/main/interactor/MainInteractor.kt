package com.teamdevmaurez.kotlintest.ui.main.interactor

import com.teamdevmaurez.kotlintest.data.repository.MangaRepositoryHelper
import com.teamdevmaurez.kotlintest.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 15/03/2018.
 */
class MainInteractor @Inject internal constructor(mangaRepositoryHelper: MangaRepositoryHelper) : BaseInteractor(aMangaRepositoryHelper = mangaRepositoryHelper), MainMVPInteractor {

    // override fun getMangaList() = mangaRepositoryHelper.getMangas()

}