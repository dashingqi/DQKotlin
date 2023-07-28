package com.dashingqi.arithmetic.solution

import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Android 算法解决
 * @author zhangqi61
 * @since 2023/7/28
 */
class DQAndroidSolution {

    /**
     * 深度优先
     * 使用递归遍历子View
     * @param view View
     */
    private fun printViewTree(view: View) {
        getViewInfo(view)
        when (view) {
            is ViewGroup -> {
                val childCount = view.childCount
                for (childIndex in 0 until childCount) {
                    val childView = view.getChildAt(childIndex)
                    printViewTree(childView);
                }
            }
            else -> {
                // do nothing
            }
        }
    }

    /**
     * 打印子View使用Stack
     * @param view View 打印子View
     */
    private fun printViewTreeTwo(view:View){
        val viewTreeStack = Stack<View>()
        viewTreeStack.push(view)
        while (!viewTreeStack.isEmpty()) {
            val currentView = viewTreeStack.pop()
            getViewInfo(currentView)
            when (view) {
                is ViewGroup -> {
                    val childCount = view.childCount
                    var childIndex = childCount - 1
                    while (childIndex >= 0) {
                        val childView = view.getChildAt(childIndex)
                        viewTreeStack.push(childView)
                        childIndex--;
                    }
                }
                else -> {
                    // do nothing
                }
            }
        }
    }

    /**
     * 打印View的信息
     * @param view View view
     * @return String info
     */
    private fun getViewInfo(view: View):String {
        val sb = StringBuilder()
        sb.append("(${view.id})")
            .append("[${view.left},${view.top},${view.right},${view.bottom}]")
        return sb.toString()
    }
}