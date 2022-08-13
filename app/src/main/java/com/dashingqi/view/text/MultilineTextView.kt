package com.dashingqi.view.text

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.dashingqi.dqkotlin.R
import com.dashingqi.ext.dp

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/13 11:42
 */


private val AVATAR_PADDING_TOP = 50.dp

private val AVATAR_WIDTH = 150.dp

private const val TEXT =
    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
            "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, " +
            "as opposed to using 'Content here, content here', making it look like readable English. " +
            "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, " +
            "and a search for 'lorem ipsum' will uncover many web sites still in their infancy. " +
            "Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."

class MultilineTextView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(AVATAR_WIDTH.toInt())
    private val fontMetrics = Paint.FontMetrics()
    private val measureWidthArray = floatArrayOf()

    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 绘制多行文字
//        val staticLayout = StaticLayout(
//            text,
//            textPaint,
//            width,
//            Layout.Alignment.ALIGN_NORMAL,
//            1f,
//            0f,
//            false
//        )
//        staticLayout.draw(canvas)

        // 画头像
        canvas.drawBitmap(bitmap, width - AVATAR_WIDTH, AVATAR_PADDING_TOP, paint)
        textPaint.getFontMetrics(fontMetrics)

        // 每一行的文字的启始
        var start = 0
        // 每一行绘制文字的个数
        var count: Int
        // 行距离
        var verticalOffset = -fontMetrics.top
        // 真正
        var realWidth = 0f


        while (start < TEXT.length) {
            val isTopNotInMetrics = fontMetrics.top + verticalOffset > AVATAR_PADDING_TOP + AVATAR_WIDTH
            val isBottomNotInMetrics = fontMetrics.bottom + verticalOffset < AVATAR_PADDING_TOP
            realWidth = if (isTopNotInMetrics || isBottomNotInMetrics) {
                width.toFloat()
            } else {
                width.toFloat() - AVATAR_WIDTH
            }

            // 测量有限空间绘制文字的个数
            count = textPaint.breakText(
                TEXT,
                start,
                TEXT.length,
                true,
                realWidth,
                measureWidthArray
            )

            // 绘制文字
            canvas.drawText(
                TEXT,
                start,
                start + count,
                0f,
                verticalOffset,
                textPaint
            )
            start += count
            verticalOffset += textPaint.fontSpacing

        }
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