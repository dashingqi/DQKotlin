package com.dashingqi.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @desc : 画一个圆形
 * @author : zhangqi
 * @time : 2023/9/3 10:13
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    /** 画笔*/
    private val paint = Paint()

    private val RADIUS = 100.dp

    private val PADDING = 100.dp

    init {
        paint.color = Color.RED
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = ((RADIUS + PADDING) * 2).toInt()
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)

    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }
}