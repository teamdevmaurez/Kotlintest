package com.teamdevmaurez.kotlintest.data.repository

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import io.reactivex.Observable

interface MangaRepositoryHelper {

    fun count(): Observable<Int>
    fun getMangas(): Observable<List<MangaEntity>>

}