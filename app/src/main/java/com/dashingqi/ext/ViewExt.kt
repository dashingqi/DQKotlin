package com.dashingqi.ext

import android.content.res.Resources
import android.util.TypedValue

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/6 16:30
 */


/**
 * dp2px
 * Float类型
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

/**
 * dp2px
 * Int类型
 */
val Int.dp
    get() = this.toFloat().dp