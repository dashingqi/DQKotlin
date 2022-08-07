package com.dashingqi.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.px

/**
 * @desc : 圆头像View
 * @author : zhangqi
 * @time : 2022/8/7 16:55
 */


private val OVAL_PADDING_LEFT = 100f.px

private val OVAL_PADDING_TOP = 40f.px

private val OVAL_WIDTH = 80f.px

class XFerModeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    /** 画笔*/
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    /** XFerMode*/
    private val porterDuffXFerMode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    /** 离屏渲染的区域*/
    private val layerBounds = RectF(
        OVAL_PADDING_LEFT,
        OVAL_PADDING_TOP,
        OVAL_PADDING_LEFT + OVAL_WIDTH + OVAL_WIDTH / 2f,
        OVAL_PADDING_TOP + OVAL_WIDTH + OVAL_WIDTH / 2f
    )

    /** 圆形的Bitmap 背景图*/
    private val circleBitmap = Bitmap.createBitmap(
        (OVAL_WIDTH + OVAL_WIDTH / 2f).toInt(),
        (OVAL_WIDTH + OVAL_WIDTH / 2f).toInt(), Bitmap.Config.ARGB_8888
    )

    /** 正方形的Bitmap 背景图*/
    private val squareBitmap = Bitmap.createBitmap(
        (OVAL_WIDTH + OVAL_WIDTH / 2f).toInt(),
        (OVAL_WIDTH + OVAL_WIDTH / 2f).toInt(), Bitmap.Config.ARGB_8888
    )

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.parseColor("#00FAFF")
        canvas.drawOval(
            OVAL_WIDTH / 2f,
            0f.px,
            OVAL_WIDTH / 2f + OVAL_WIDTH,
            OVAL_WIDTH,
            paint
        )
        paint.color = Color.parseColor("#8B00FF")
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(
            0f.px,
            OVAL_WIDTH / 2f,
            OVAL_WIDTH,
            OVAL_WIDTH / 2f + OVAL_WIDTH,
            paint
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val layerCount = canvas.saveLayer(layerBounds, null)
        canvas.drawBitmap(circleBitmap, OVAL_PADDING_LEFT, OVAL_PADDING_TOP, paint)
        paint.xfermode = porterDuffXFerMode
        canvas.drawBitmap(squareBitmap, OVAL_PADDING_LEFT, OVAL_PADDING_TOP, paint)
        paint.xfermode = null
        canvas.restoreToCount(layerCount)

    }

}