package com.teamdevmaurez.kotlintest.data.repository

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import io.reactivex.Observable

/**
 * Created by teamdevmaurez on 26/03/2018.
 */
interface MangaRepositoryHelper {

    fun count() : Observable<Int>
    fun getMangas(): Observable<List<MangaEntity>>

}