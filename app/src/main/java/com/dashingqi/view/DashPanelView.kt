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
 * @desc : 仪表盘
 * @author : zhangqi
 * @time : 2022/8/6 16:57
 */


/** 仪表盘的半径*/
private val DASH_RADIUS = 150f.dp

private val POINT_LENGTH = 120f.dp

/** 刻度个数*/
private const val MARK_COUNT = 20

/** 当前指向的刻度 */
private const val CURRENT_POINT_COUNT = 10

/** 开口角度*/
private const val OPEN_ANGLE = 90f

/** 刻度宽度*/
private val DASH_WIDTH = 2f.dp

/** 刻度高度*/
private val DASH_LENGTH = 10f.dp

private const val TAG = "DashboardView"

class DashPanelView(context: Context?, attrs: AttributeSet) :
    View(context, attrs) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val dashPath = Path()

    private val path = Path()

    lateinit var arcPathDashPathEffect: PathDashPathEffect

    lateinit var pathMeasure: PathMeasure

    init {
        paint.strokeWidth = 3f.dp
        paint.style = Paint.Style.STROKE
        // 画的刻度
        dashPath.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d(TAG, "onSizeChanged perform ")
        path.reset()
        path.addArc(
            width / 2f - DASH_RADIUS,
            height / 2f - DASH_RADIUS,
            width / 2f + DASH_RADIUS,
            height / 2f + DASH_RADIUS,
            90f + OPEN_ANGLE / 2f,
            360f - OPEN_ANGLE
        )
        // 计算Path的长度
        pathMeasure = PathMeasure(path, false)
        // 计算每个刻度之间的距离
        val markAdvance = (pathMeasure.length - DASH_WIDTH) / MARK_COUNT
        arcPathDashPathEffect = PathDashPathEffect(
            dashPath,
            markAdvance,
            0f,
            PathDashPathEffect.Style.ROTATE
        )

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw perform ")

        // 画弧
        canvas.drawPath(path, paint)

        // 画刻度
        paint.pathEffect = arcPathDashPathEffect
        canvas.drawPath(
            path, paint
        )

        paint.pathEffect = null

        // 画指针
        canvas.drawLine(
            width / 2f,
            height / 2f,
            width / 2f +
                    POINT_LENGTH *
                    cos(
                        computePointRadians(MARK_COUNT, CURRENT_POINT_COUNT)
                    ).toFloat(),
            height / 2f +
                    POINT_LENGTH *
                    sin(computePointRadians(MARK_COUNT, CURRENT_POINT_COUNT)).toFloat(),
            paint
        )
    }

    /**
     *  计算指针的角度
     * @param markCount Int 刻度的个数
     * @param pointMark Int 当前指向的刻度
     * @return Double 角度
     */
    private fun computePointRadians(markCount: Int, pointMark: Int): Double {
        return Math.toRadians(
            (90 + OPEN_ANGLE / 2f +
                    ((360 - OPEN_ANGLE) / markCount) * pointMark).toDouble()
        )
    }

}