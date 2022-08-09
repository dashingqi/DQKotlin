package com.dashingqi.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.dashingqi.ext.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * @desc : 饼图
 * @author : zhangqi
 * @time : 2022/8/7 15:30
 */


/** 饼图的半径*/
private val PIE_RADIUS = 150f.dp

/** 偏移量 */
private val OFFSET_LENGTH = 24f.dp

/** 饼图的角度*/
private val ANGLES = floatArrayOf(70f, 110f, 120f, 60f)

/** 饼图的颜色集合*/
private val COLORS = listOf(
    Color.parseColor("#C2185B"),
    Color.parseColor("#00CAC1"),
    Color.parseColor("#558BF2"),
    Color.parseColor("#5D5023")
)


private const val TAG = "DashboardView"

class PieView(context: Context?, attrs: AttributeSet) :
    View(context, attrs) {
    /** 画笔 */
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        Log.d(TAG, "onDraw perform ")
        // 开始角度
        var startAngle = 0f
        for ((index, angle) in ANGLES.withIndex()) {
            // 设置画笔的颜色
            paint.color = COLORS[index]

            if (index == 1) {
                canvas.save()
                canvas.translate(
                    (OFFSET_LENGTH * cos(computeTranslateRadians(startAngle, angle))).toFloat(),
                    (OFFSET_LENGTH * sin(computeTranslateRadians(startAngle, angle))).toFloat()
                )
            }

            // 画饼
            canvas.drawArc(
                width / 2f - PIE_RADIUS,
                height / 2f - PIE_RADIUS,
                width / 2f + PIE_RADIUS,
                height / 2f + PIE_RADIUS,
                startAngle, angle, true, paint
            )
            // 递增开始角度
            startAngle += angle
            if (index == 1) {
                canvas.restore()
            }
        }
    }

    /**
     * 计算 偏移角度
     * @param startAngle Float
     * @param swipeAngle Float
     * @return Double
     */
    private fun computeTranslateRadians(startAngle: Float, swipeAngle: Float): Double {
        return Math.toRadians((startAngle + swipeAngle / 2f).toDouble())
    }
}