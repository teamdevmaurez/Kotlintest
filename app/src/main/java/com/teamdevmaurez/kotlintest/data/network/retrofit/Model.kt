package com.teamdevmaurez.kotlintest.data.network.retrofit

import com.squareup.moshi.Json
import java.util.*


object Model {

    data class Chapter(var href: String, var name: String, var pages: List<Page>, var lastUpdate: Date)

    data class Page(var pageId: Int, var url: String)

    data class Manga(@Json(name = "mangaId")
                     var mangaId: String = "",

                     @Json(name = "name")
                     var name: String = "",

                     @Json(name = "info")
                     var info: String = "",

                     @Json(name = "cover")
                     var cover: String = "")

}
