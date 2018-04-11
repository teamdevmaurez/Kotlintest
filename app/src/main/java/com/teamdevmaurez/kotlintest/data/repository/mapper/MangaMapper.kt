package org.buffer.android.boilerplate.data.mapper

import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.data.network.retrofit.Model
import javax.inject.Inject


/**
 * Map a [MangaEntity] to and from a [Model.Manga] instance when data is moving between
 * this later and the Domain layer
 */
open class MangaMapper @Inject constructor() : Mapper<MangaEntity, Model.Manga> {

    /**
     * Map a [MangaEntity] instance to a [Model.Manga] instance
     */
    override fun mapFromEntity(mangaEntity: MangaEntity): Model.Manga {
        return Model.Manga(mangaEntity.mangaId, mangaEntity.name, mangaEntity.info, mangaEntity.cover)
    }

    /**
     * Map a [Model.Manga] instance to a [MangaEntity] instance
     */
    override fun mapToEntity(manga: Model.Manga): MangaEntity {
        return MangaEntity(manga.mangaId, manga.name, manga.info, manga.cover)
    }


}