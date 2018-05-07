package com.teamdevmaurez.kotlintest.data.database.mangas

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Single

@Dao
interface MangaDao {

    @Query("SELECT COUNT(*) FROM mangas")
    fun count(): Single<Int>

    @Query("SELECT * FROM mangas")
    fun getMangas(): Single<List<MangaEntity>>

    @Insert(onConflict = REPLACE)
    fun insertManga(mangas: MangaEntity)

    @Insert(onConflict = REPLACE)
    fun insertMangas(mangas: List<MangaEntity>)

    @Update(onConflict = REPLACE)
    fun updateManga(manga: MangaEntity)

    @Delete
    fun deleteManga(manga: MangaEntity)
}