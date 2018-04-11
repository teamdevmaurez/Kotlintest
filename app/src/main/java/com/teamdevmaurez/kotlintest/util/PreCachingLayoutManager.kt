package com.teamdevmaurez.kotlintest.util

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class PreCachingLayoutManager : LinearLayoutManager {
    companion object {
        const val DEFAULT_EXTRA_LAYOUT_SPACE = 600
        const val EXTRA_LAYOUT_SPACE_NOT_SET = -1
    }

    private var extraLayoutSpace = EXTRA_LAYOUT_SPACE_NOT_SET
    private var context: Context? = null

    constructor(context: Context) : super(context) {
        this.context = context
    }

    fun setExtraLayoutSpace(extraLayoutSpace: Int) {
        this.extraLayoutSpace = extraLayoutSpace
    }

    override fun getExtraLayoutSpace(state: RecyclerView.State): Int {
        return if (extraLayoutSpace > 0) {
            extraLayoutSpace
        } else {
            DEFAULT_EXTRA_LAYOUT_SPACE
        }
    }


}
