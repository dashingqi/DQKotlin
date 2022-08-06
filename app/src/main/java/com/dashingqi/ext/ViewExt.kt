package com.dashingqi.ext

import android.content.res.Resources
import android.util.TypedValue

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/6 16:30
 */

/**
 * dp2Px
 * @receiver Float dp单位
 * @param value Float dp值
 * @return Float px值
 */
val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )