package com.dashingqi.dqkotlin.ext

/**
 * @author zhangqi61
 * @since 2022/1/4
 */

fun String.isEmpty(): Boolean {
    return this.isNullOrEmpty()
}