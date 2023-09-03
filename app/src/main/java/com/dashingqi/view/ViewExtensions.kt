package com.dashingqi.view

import android.content.res.Resources
import android.util.TypedValue

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/9/3 09:15
 */

fun Float.dp(): Float {
   return  TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics
    )
}

fun Int.dp(): Float {
    return  TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics
    )
}

val Int.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics
    )