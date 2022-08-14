package com.dashingqi.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.dp

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/14 09:16
 */
class CircleView(context: Context?, attributeSet: AttributeSet?) : View(context, attributeSet) {

    val radius = 100.dp

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)
        908244935

    }
}