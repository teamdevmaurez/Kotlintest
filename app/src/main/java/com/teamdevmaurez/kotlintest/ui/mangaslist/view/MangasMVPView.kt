package com.teamdevmaurez.kotlintest.ui.mangaslist.view

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.ui.base.view.BaseView


interface MangasMVPView : BaseView {

    fun displayMangaList(mangas: List<MangaEntity>?)

    fun hideEmptylist()

    fun showEmptylist()

}