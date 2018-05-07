package com.teamdevmaurez.kotlintest.ui.main.interactor

import com.teamdevmaurez.kotlintest.data.repository.MangaRepositoryHelper
import com.teamdevmaurez.kotlintest.ui.base.interactor.BaseInteractor
import javax.inject.Inject


class MainInteractor @Inject internal constructor(mangaRepositoryHelper: MangaRepositoryHelper) : BaseInteractor(aMangaRepositoryHelper = mangaRepositoryHelper), MainMVPInteractor {

}