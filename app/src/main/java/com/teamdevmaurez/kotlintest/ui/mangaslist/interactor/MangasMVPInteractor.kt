package com.teamdevmaurez.kotlintest.ui.mangaslist.interactor

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
interface MangasMVPInteractor : MVPInteractor {

    fun getMangaList(): Observable<List<MangaEntity>>

}