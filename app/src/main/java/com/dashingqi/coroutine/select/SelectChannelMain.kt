package com.dashingqi.coroutine.select

import android.util.Log
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

/**
 * @desc : select 和 channel配合使用
 * @author : zhangqi
 * @time : 2022/4/17 10:45
 */
private const val TAG = "SelectChannelMain"
fun selectChannelMethod() = runBlocking {

    val startTime = System.currentTimeMillis()

    val channel1 = produce<String> {
//        send("1")
//        delay(200L)
//        send("2")
//        delay(200L)
//        send("3")
        delay(1500L)
    }

    val channel2 = produce<String> {
        delay(100L)
        send("a")
        delay(200L)
        send("b")
        delay(200L)
        send("c")
    }

    repeat(6) {
        val result = selectChannel(channel1, channel2)
        Log.d(TAG, "result is $result")
    }

    channel1.cancel()
    channel2.cancel()

    Log.d(TAG, "Time cost : ${System.currentTimeMillis() - startTime}")
}

suspend fun selectChannel(channel1: ReceiveChannel<String>, channel2: ReceiveChannel<String>) = select<String> {
    // onReceive 替换成onReceiveCaching
    channel1.onReceiveCatching {
        it.getOrNull() ?: "channel1 is closed"
    }

    channel2.onReceiveCatching {
        it.getOrNull() ?: "channel2 is closed"
    }
}

fun cancelAllDeferred() = runBlocking {

    val deferred1 = async {
        delay(100L)
        println("done1")
        "result1"
    }

    val deferred2 = async {
        delay(50L)
        println("done2")
        "result2"
    }

    val deferred3 = async {
        delay(10000L)
        println("done3")
        "result3"
    }

    val deferred4 = async {
        delay(2000L)
        println("done4")
        "result4"
    }

    val deferred5 = async {
        delay(14000L)
        println("done5")
        "result5"
    }

    val result = fastest(deferred1, deferred2, deferred3, deferred4, deferred5)
    println("result is $result")

}

suspend fun <T> fastest(vararg deferreds: Deferred<T>): T = select {
    fun cancelAll() = deferreds.forEach { it.cancel() }

    for (deferred in deferreds) {
        deferred.onAwait {
            cancelAll()
            it
        }
    }
}