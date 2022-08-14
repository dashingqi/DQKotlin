package com.dashingqi.view.range

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.dashingqi.dqkotlin.R
import com.dashingqi.ext.dp

/**
 * @desc : 区域裁剪以及几何变换
 * @author : zhangqi
 * @time : 2022/8/13 21:43
 *
 * 区域裁剪
 * clipReact()
 * clipPath()
 *
 * 几何变换
 *
 * canvas的几何变换  移动的是canvas的坐标系
 * translate(x,y)
 * rotate(degree)
 * scale(x,y)
 * skew(x,y)
 *
 * Matrix的几何变换
 * preTranslate(x,y)/postTranslate(x,y)
 * preRotate()/postRotate()
 *
 * Camera 三维变换
 * 倒着想，倒着写
 */

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

class ClipView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val clipped = Path().apply {
        addOval(
            BITMAP_PADDING, BITMAP_PADDING,
            BITMAP_PADDING + BITMAP_SIZE, BITMAP_PADDING + BITMAP_SIZE, Path.Direction.CCW
        )
    }

    private val camera = Camera()

    init {
        camera.rotateX(30f)
        // 设置投影点的位置 和屏幕像素关联
        // -6 是英寸 大概英寸的值
        camera.setLocation(0f, 0f, -6f * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 区域裁剪
//        canvas.clipRect(
//            BITMAP_PADDING, BITMAP_PADDING,
//            BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2
//        )
//        // canvas.clipPath(clipped)

        // 几何变换

        canvas.withSave {
            canvas.translate(
                (BITMAP_PADDING + BITMAP_SIZE / 2),
                (BITMAP_PADDING + BITMAP_SIZE / 2)
            )
            // 倒着想 倒着写 总结的规律
            canvas.clipRect(
                -BITMAP_SIZE / 2,
                -BITMAP_SIZE / 2,
                BITMAP_SIZE / 2,
                0f
            )
            canvas.translate(
                -(BITMAP_PADDING + BITMAP_SIZE / 2),
                -(BITMAP_PADDING + BITMAP_SIZE / 2)
            )

            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }


        // 下半身
        canvas.withSave {
            canvas.translate(
                (BITMAP_PADDING + BITMAP_SIZE / 2),
                (BITMAP_PADDING + BITMAP_SIZE / 2)
            )
            camera.applyToCanvas(canvas)


            // 倒着想 倒着写
            canvas.clipRect(
                -BITMAP_SIZE / 2,
                0f,
                BITMAP_SIZE / 2,
                BITMAP_SIZE / 2
            )
            canvas.translate(
                -(BITMAP_PADDING + BITMAP_SIZE / 2),
                -(BITMAP_PADDING + BITMAP_SIZE / 2)
            )


            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
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