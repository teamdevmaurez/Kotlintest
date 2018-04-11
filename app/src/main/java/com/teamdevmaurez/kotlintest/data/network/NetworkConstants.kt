package com.teamdevmaurez.kotlintest.data.network


object NetworkConstants {

    const val HEADER_ACCEPT = "Accept: text/plain"

    /**
     * @TODO do not keep key here
     */
    const val HEADER_XMASHAPE_KEY = "X-Mashape-Key: XpT6FskaMZmshAo2FuNfnf61tecQp1I8aZFjsnWfIc2fdBJJRK"

    const val COVER_PARAMETER = 1
    const val INFO_PARAMETER = 1

    const val CACHE_SIZE = 10 * 1024 * 1024.toLong() // 10 MB
}