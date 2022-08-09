package com.dashingqi.view.text

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.dp

/**
 * 自定义测量文字
 * @author zhangqi61
 * @since 2022/8/9
 */

/** 半径*/
val CIRCLE_RADIUS = 160f.dp

/** 高亮线的颜色*/
private const val HIGH_LINE_COLOR = "#00FAFF"

/** 高亮线启始角度*/
private const val HIGH_LINE_START_ANGLE = -90f

/** 高亮线划过角度*/
private const val HIGH_LINE_SWIPE_ANGLE = 220f

/** 文字 */
private const val HIGH_LINE_TEXT = "dashingqi"

/** 文字颜色 */
private const val TEXT_COLOR = "#F0F0A5"

/** 文字大小*/
val TEXT_SIZE = 60f.dp

/** 圆 Stroke Width*/
val CIRCLE_STROKE_WIDTH = 10f.dp

val textBounds = Rect()


class CustomMeasureText(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    /** 画笔*/
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        textSize = TEXT_SIZE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 画一个圆圈
        paint.strokeWidth = CIRCLE_STROKE_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, CIRCLE_RADIUS, paint)

        // 画一个弧
        paint.color = Color.parseColor(HIGH_LINE_COLOR)
        // 头尾圆滑
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - CIRCLE_RADIUS,
            height / 2f - CIRCLE_RADIUS,
            width / 2f + CIRCLE_RADIUS,
            height / 2f + CIRCLE_RADIUS,
            HIGH_LINE_START_ANGLE,
            HIGH_LINE_SWIPE_ANGLE,
            false,
            paint
        )

        // 画静态文字
        paint.color = Color.parseColor(TEXT_COLOR)
        paint.textAlign = Paint.Align.CENTER
        paint.style = Paint.Style.FILL
        paint.getTextBounds(HIGH_LINE_TEXT, 0, HIGH_LINE_TEXT.length - 1, textBounds)
        canvas.drawText(
            HIGH_LINE_TEXT,
            width / 2f,
            height / 2f + (textBounds.bottom - textBounds.top) / 2f,
            paint
        )
    }
}