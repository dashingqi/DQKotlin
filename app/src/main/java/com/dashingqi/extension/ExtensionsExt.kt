package com.dashingqi.extension

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginLeft
import androidx.core.view.marginTop

/**
 * 匿名内部类不能被扩展
 * @author zhangqi61
 * @since 2022/10/19
 *
 * 扩展不能做什么
 * 1. Kotlin扩展不是真正的类成员，因此它无法被它的子类重写
 * 2. 扩展属性无法存储状态
 * 3. 扩展的访问作用域仅限于两个地方
 *    扩展是顶层扩展，那么扩展访问的区域仅限于该Kotlin文件当中的成员以及被扩展类型的公开成员，这种定义的方式是可以被全局使用；
 *    扩展被定义到某个类中，那么扩展访问区域仅被限于该类中当中的所有成员以及被扩展类型的公开成员，这种定义的扩展仅能在该类中使用；
 */

inline fun <reified T : ViewGroup.LayoutParams> View.updateLayoutParams(block: T.() -> Unit) {
    val params = layoutParams as T
    block(params)
    layoutParams = params
}

fun View.updateMargin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            left?.let {
                this.marginStart = left
            }

            top?.let {
                this.topMargin = top
            }

            right?.let {
                this.marginEnd = right
            }

            bottom?.let {
                this.bottomMargin = bottom
            }
        }
    }
}

