package com.dashingqi.view.measurelayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.dp

/**
 * @desc : 圆形View
 * @author : zhangqi
 * @time : 2022/8/28 16:02
 */


private val RADIUS = 100.dp

private val PADDING = 100.dp

class CircleView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // 测量View的大小
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = ((RADIUS + PADDING) * 2).toInt()
        // 听开发者的话,如果开发者自己本身指定了具体值
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    // 在View上进行绘制
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }
}