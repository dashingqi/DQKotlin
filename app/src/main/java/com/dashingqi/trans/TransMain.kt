package com.dashingqi.trans

import android.appwidget.AppWidgetManager
import android.content.Context
import android.util.Log

/**
 * @author zhangqi61
 * @since 2023/5/23
 */

fun transMain() {
    val str = "Dashingqi"

}

class TransMain {

    fun changeTrans(transModel: String?, context: Context) {
        val itValue = transModel?.let {
            0
        } ?: {

        }
        Log.d("TransMain", "itValue = $itValue")

        val transModelValue = transModel?.apply {
            0
        }
        Log.d("TransMain", "transModelValue = $transModelValue")

        val withValue = with(transModel) {
            ""
        }
        Log.d("TransMain", "withValue = $withValue")

        val alsoValue = transModel?.also {
            0
        }
        Log.d("TransMain", "alsoValue = $alsoValue")

        val obj = AppWidgetManager.getInstance(context).run {

        }
    }
}

inline fun performOperation(a: Int, b: Int, crossinline operation: (Int, Int) -> Unit) {
    operation(a, b)
}

fun performMain() {
    performOperation(1, 2) { a, b ->
        a + b
    }
    Log.d("TAG", "performMain: ")
}

internal fun method(){

}