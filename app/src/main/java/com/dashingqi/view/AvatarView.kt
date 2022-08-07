package com.dashingqi.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dashingqi.dqkotlin.R
import com.dashingqi.ext.px

/**
 * @desc : 圆头像View
 * @author : zhangqi
 * @time : 2022/8/7 16:55
 */


/** 画的图片宽度*/
private val IMAGE_WIDTH = 200f.px

/** 图片距离顶部与左部的距离*/
private val IMAGE_PADDING = 40f.px

class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    /** 画笔*/
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    /** XFerMode*/
    private val porterDuffXFerMode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    /** 离屏缓冲的区域*/
    private val bounds = RectF(
        IMAGE_PADDING,
        IMAGE_PADDING,
        IMAGE_PADDING + IMAGE_WIDTH,
        IMAGE_PADDING + IMAGE_WIDTH
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 离屏缓冲,拿到屏幕中的固定一块区域，我们在这个区域做绘制
        // 绘制完成后，再把该区域复原
        // 性能比较差，区域能多小就多小
        val layerCount = canvas.saveLayer(
            bounds, null
        )
        canvas.drawOval(
            IMAGE_PADDING,
            IMAGE_PADDING,
            IMAGE_PADDING + IMAGE_WIDTH,
            IMAGE_PADDING + IMAGE_WIDTH,
            paint
        )
        paint.xfermode = porterDuffXFerMode
        canvas.drawBitmap(
            getAvatar(IMAGE_WIDTH.toInt()),
            IMAGE_PADDING,
            IMAGE_PADDING,
            paint
        )
        paint.xfermode = null
        canvas.restoreToCount(layerCount)

    }


    /**
     * 获取头像
     * @param width Int 设定的目标宽度
     * @return Bitmap avatar Bitmap
     */
    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
    }
}