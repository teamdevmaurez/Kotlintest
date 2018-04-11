package com.teamdevmaurez.kotlintest.ui.mangaslist.view

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.ui.base.view.BaseView

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
interface MangasMVPView : BaseView {

    fun displayMangaList(mangas: List<MangaEntity>?): Unit?

}