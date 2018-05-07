package com.teamdevmaurez.kotlintest.data.database.mangas

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "mangas")
data class MangaEntity(

        @ColumnInfo(name = "manga_id")
        @PrimaryKey(autoGenerate = false)
        var mangaId: String,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "info")
        var info: String,

        @ColumnInfo(name = "cover")
        var cover: String)
