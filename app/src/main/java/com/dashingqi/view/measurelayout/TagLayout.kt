package com.dashingqi.view.measurelayout

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/8/30 22:47
 */
class TagLayout(context: Context?, attributeSet: AttributeSet?) :
    ViewGroup(context, attributeSet) {

    private val childrenBounds = mutableListOf<Rect>()
    private var lineMaxHeight = 0
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 需要声明每行最大的宽度
        // 以及记录每行最大的高度值
        var widthUsed = 0
        var heightUsed = 0
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
            measureChildWithMargins(
                child,
                widthMeasureSpec,
                widthUsed,
                heightMeasureSpec,
                heightUsed
            )
            if (specMode != MeasureSpec.UNSPECIFIED &&
                widthUsed + child.measuredWidth > specWidth
            ) {

            }
            if (index >= childrenBounds.size) {
                childrenBounds.add(Rect())
            }
            val childBounds = childrenBounds[index]
            childBounds.set(
                widthUsed,
                heightUsed,
                widthUsed + child.measuredWidth,
                heightUsed + child.measuredHeight
            )
            widthUsed += child.measuredWidth
            heightUsed += child.measuredHeight
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }

        val selfWidth = widthUsed
        val selfHeight = lineMaxHeight
        setMeasuredDimension(selfWidth, selfHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childBounds = childrenBounds[index]
            child.layout(
                childBounds.left,
                childBounds.top,
                childBounds.right,
                childBounds.bottom
            )
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}