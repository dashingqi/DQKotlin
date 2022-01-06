package com.dashingqi.dqkotlin.ext

/** String 顶层扩展
 * @author zhangqi61
 * @since 2022/1/4
 */



/**
 * 顶层扩展 -> 函数扩展
 * @receiver String
 * @return Int
 */
fun String.lengthExt(): Int {
    return length
}

/**
 * 顶层扩展 -> 属性扩展
 */
val String?.isNullOrBlankExt: Boolean
    get() = this == null || this.isEmpty()