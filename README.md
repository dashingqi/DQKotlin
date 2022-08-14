# DQKotlin

#### 自定义View 
android-view 分支
###### 仪表盘
```kotlin
 arcPathDashPathEffect = PathDashPathEffect(
    dashPath,
    markAdvance,
    0f,
    PathDashPathEffect.Style.ROTATE
)
```
![仪表盘](https://upload-images.jianshu.io/upload_images/4997216-16a358f813540fc9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 饼图
```kotlin
canvas.translate(
    (OFFSET_LENGTH * cos(computeTranslateRadians(startAngle, angle))).toFloat(),
    (OFFSET_LENGTH * sin(computeTranslateRadians(startAngle, angle))).toFloat()
)
```
![饼图](https://upload-images.jianshu.io/upload_images/4997216-d47ad63bf134b6bc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 画圆头像
```kotlin
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
```
![圆头像](https://upload-images.jianshu.io/upload_images/4997216-dbb832d5c57217af.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![xfermode属性的理解](https://upload-images.jianshu.io/upload_images/4997216-9ecc10197bc32f65.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 画文字居中
```kotlin
paint.getTextBounds(HIGH_LINE_TEXT, 0, HIGH_LINE_TEXT.length - 1, textBounds)
canvas.drawText(
    HIGH_LINE_TEXT,
    width / 2f,
    height / 2f - (textBounds.bottom + textBounds.top) / 2f,
    paint
)
```
![text.png](https://upload-images.jianshu.io/upload_images/4997216-c1f7cf0b32f1148e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 画文字贴边
```kotlin
paint.getFontMetrics(fontMetrics)
paint.getTextBounds("adab", 0, "abab".length, textBounds)
canvas.drawText("abab", -textBounds.left.toFloat(), -fontMetrics.top.toFloat(), paint)
```
![![Screenshot_20220813_165754.png](https://upload-images.jianshu.io/upload_images/4997216-0d66b403d4451529.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 图文混排
```kotlin
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
```
![](https://upload-images.jianshu.io/upload_images/4997216-2e076dfe86a88aa5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 区域裁剪以及几何变换
```kotlin

camera.rotateX(30f)
// 设置投影点的位置 和屏幕像素关联
// -6 是英寸 大概英寸的值
camera.setLocation(0f, 0f, -6f * resources.displayMetrics.density)

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


```
![clip-camera.png](https://upload-images.jianshu.io/upload_images/4997216-c1acf14ae79cf274.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)