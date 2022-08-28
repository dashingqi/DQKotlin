package com.dashingqi.view.drawablebitmap

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.dashingqi.ext.dp

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/27 15:49
 *
 * Drawable :是一个绘制工具
 * Bitmap ：是承载图像的像素
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val drawable = MeshDrawable()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
        drawable.draw(canvas)
    }
}