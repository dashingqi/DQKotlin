package com.dashingqi.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.dashingqi.ext.px

/**
 * @desc : 仪表盘
 * @author : zhangqi
 * @time : 2022/8/6 16:57
 */


/** 仪表盘的半径*/
val DASH_RADIUS = 150f.px

val POINT_LENGTH = 120f.px

/** 刻度个数*/
const val MARK_COUNT = 20

/** 开口角度*/
const val OPEN_ANGLE = 90

/** 刻度宽度*/
val DASH_WIDTH = 2f.px

/** 刻度高度*/
val DASH_LENGTH = 10f.px

const val TAG = "DashboardView"

class DashboardView(context: Context?, attrs: AttributeSet) :
    View(context, attrs) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val dashPath = Path()

    private val path = Path()

    lateinit var arcPathDashPathEffect: PathDashPathEffect

    lateinit var pathMeasure: PathMeasure

    init {
        paint.strokeWidth = 3f.px
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
        pathMeasure = PathMeasure(path, false)
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
    }

}