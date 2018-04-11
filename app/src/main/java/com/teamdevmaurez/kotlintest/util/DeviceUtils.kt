package com.teamdevmaurez.kotlintest.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

object DeviceUtils {

    /**
     * @param context
     * @return the screen height in pixels
     */
    fun getScreenHeight(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y
    }

    /**
     * @param context
     * @return the screen width in pixels
     */
    fun getScreenWidth(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }
}
