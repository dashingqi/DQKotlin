package com.dashingqi.view.drawablebitmap

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.core.graphics.toColorInt
import com.dashingqi.ext.dp

/**
 * @desc : 自定义Drawable
 * @author : zhangqi
 * @time : 2022/8/27 15:57
 */
class MeshDrawable : Drawable() {

    /**
     * 画笔
     */
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = "#DBDB70".toColorInt()
        strokeWidth = 5.dp
    }

    /** 间隔*/
    private val INTERVAL = 40.dp

    override fun draw(canvas: Canvas) {

        var x: Float = bounds.left.toFloat()
        while (x < bounds.right) {
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
            x += INTERVAL
        }

        var y: Float = bounds.top.toFloat()
        while (y < bounds.bottom) {
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, paint)
            y += INTERVAL
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    /**
     * 不透明度
     * @return Int
     */
    override fun getOpacity(): Int {

        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }
}