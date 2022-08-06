package com.dashingqi.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.px

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/6 16:32
 */

val RADIUS = 100f.px

class TestView(context: Context?, attrs: AttributeSet) :
    View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val path = Path()

    lateinit var pathMeasure: PathMeasure

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addCircle(width / 2f, height / 2f, RADIUS, Path.Direction.CCW)
        path.addRect(
            width / 2f - RADIUS,
            height / 2f,
            width / 2f + RADIUS,
            height / 2f + 2 * RADIUS, Path.Direction.CCW
        )
        // false 是封口之前的长度
        pathMeasure = PathMeasure(path, false)
        // path 长度
        pathMeasure.length

        path.fillType = Path.FillType.EVEN_ODD
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }

}