package com.dashingqi.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.min

/**
 * @desc : 正方形的 ImageView
 * @author : zhangqi
 * @time : 2023/9/3 09:04
 */
class SquareImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

//    override fun layout(l: Int, t: Int, r: Int, b: Int) {
//        val width = r - l
//        val height = b - t
//        val size = min(width, height)
//        super.layout(l, t, l + size, t + size)
//    }
}