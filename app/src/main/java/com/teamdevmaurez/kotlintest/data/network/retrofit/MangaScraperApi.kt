package com.teamdevmaurez.kotlintest.data.network.retrofit

import com.teamdevmaurez.kotlintest.data.network.NetworkConstants.HEADER_ACCEPT
import com.teamdevmaurez.kotlintest.data.network.NetworkConstants.HEADER_XMASHAPE_KEY
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by teamdevmaurez on 21/02/2018.
 */
interface MangaScraperApi {


    @Headers(
            HEADER_XMASHAPE_KEY,
            HEADER_ACCEPT
    )
    @GET("{siteid}/manga/{mangaid}/{chapterid}")
    fun getChapter(@Path("siteid") siteid: String,
                   @Path("mangaid") mangaid: String,
                   @Path("chapterid") chapterid: Int): Observable<Model.Chapter>


    /**
     * Change this value to 1 if you want to include cover data
     * Change this value to 1 if you want to include info data
     *
     *  @TODO do not keep key in hard
     */
    @Headers(
            HEADER_XMASHAPE_KEY,
            HEADER_ACCEPT
    )
    @GET("{siteid}")
    @Streaming
    fun getMangaList(@Path("siteid") siteid: String,
                     @Query("cover") cover: Int,
                     @Query("info") info: Int): Observable<List<Model.Manga>>

}