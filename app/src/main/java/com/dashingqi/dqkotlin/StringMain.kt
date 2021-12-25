package com.dashingqi.dqkotlin

import java.util.*

/**
 * @author zhangqi61
 * @since 2021/12/21
 */

fun main() {
    val newName = "zhangqi"
    val oldName = "zhangQi"
    val result = newName.toLowerCase() == oldName.toLowerCase()
    val result1 = newName.toUpperCase() == oldName.toUpperCase()
    newName.equals(oldName,true)

}