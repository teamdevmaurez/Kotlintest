package com.teamdevmaurez.kotlintest.data.database.mangas

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Single

/**
 * Created by teamdevmaurez on 21/03/2018.
 */
@Dao
interface MangaDao {

    @Query("SELECT COUNT(*) FROM mangas")
    fun count(): Single<Int>

    @Query("SELECT * FROM mangas")
    fun getMangas(): Single<List<MangaEntity>>

    @Insert(onConflict = IGNORE)
    fun insertManga(mangas: MangaEntity)

    @Insert(onConflict = IGNORE)
    fun insertMangas(mangas: List<MangaEntity>)

    @Update(onConflict = REPLACE)
    fun updateManga(manga: MangaEntity)

    @Delete
    fun deleteManga(manga: MangaEntity)
}