package com.teamdevmaurez.kotlintest.ui.mangaslist.interactor

import com.teamdevmaurez.kotlintest.data.repository.MangaRepositoryHelper
import com.teamdevmaurez.kotlintest.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
class MangasInteractor @Inject internal constructor(mangaRepositoryHelper: MangaRepositoryHelper) : BaseInteractor(mangaRepositoryHelper), MangasMVPInteractor {

    override fun getMangaList() = mangaRepositoryHelper.getMangas()

}