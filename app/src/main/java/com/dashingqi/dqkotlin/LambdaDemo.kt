package com.dashingqi.dqkotlin

/**
 * @author zhangqi61
 * @since 2021/12/23
 */

fun request(type: Int, call: (code: Int, type: Int) -> Unit) {
    call(200, type)
}

fun run() {
    val message = "message"
    request(1) { code, type ->
        println(message)
    }
}

