package com.dashingqi.dqkotlin

import android.util.Log

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

fun lambda() {
    lambdaFun(onSuccess = {}, onFailure = {})
}

inline fun lambdaFun(crossinline onSuccess: () -> Unit, noinline onFailure: () -> Unit) {
    Log.d(TAG, "调用前")
    onSuccess.invoke()
    Log.d(TAG, "调用后")
    failureInvoke(onFailure)
    lambdaInvoke {
        onSuccess.invoke()
    }
}

inline fun failureInvoke(failure: () -> Unit) {

}

fun lambdaInvoke(action: () -> Unit) {

}

