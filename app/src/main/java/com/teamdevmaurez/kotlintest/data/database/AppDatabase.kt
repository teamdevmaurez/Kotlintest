package com.teamdevmaurez.kotlintest.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.teamdevmaurez.kotlintest.data.database.mangas.MangaDao
import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity

@Database(entities = arrayOf(MangaEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mangasDao(): MangaDao
}