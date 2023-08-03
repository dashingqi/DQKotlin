package com.dashingqi.screen

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import kotlin.math.sqrt

/**
 * @author zhangqi61
 * @since 2023/8/2
 */

//fun getScreenDiagonalSize(context: Context): Double {
//    val wmService = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//    val metrics = DisplayMetrics()
//    wmService.defaultDisplay.getMetrics(metrics)
//    val widthPx = metrics.widthPixels
//    val heightPx = metrics.heightPixels
//    Log.d("TAG", "getScreenDiagonalSize: ")
//    return sqrt((widthPx * widthPx + heightPx * heightPx).toDouble())
//}

class AndroidScreen {

    @JvmField
    val string = ""


    class MyInner {

        fun log() {
            Log.d("TAG", "")
        }
    }

    companion object {
        fun getMethod(){

        }
    }
}