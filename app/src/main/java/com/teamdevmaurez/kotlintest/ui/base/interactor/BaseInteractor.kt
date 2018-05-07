package com.teamdevmaurez.kotlintest.ui.base.interactor

import com.teamdevmaurez.kotlintest.data.repository.MangaRepositoryHelper


open class BaseInteractor() : MVPInteractor {

    protected lateinit var mangaRepositoryHelper: MangaRepositoryHelper

    constructor(aMangaRepositoryHelper: MangaRepositoryHelper) : this() {
        this.mangaRepositoryHelper = aMangaRepositoryHelper
    }


}