# DQKotlin

#### 自定义View 
android-view 分支
###### 仪表盘
![仪表盘](https://upload-images.jianshu.io/upload_images/4997216-16a358f813540fc9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 饼图
![饼图](https://upload-images.jianshu.io/upload_images/4997216-d47ad63bf134b6bc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 画圆头像
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
