package com.dashingqi.coroutine.current

import android.util.Log
import kotlinx.coroutines.*

/**
 * 不共享可变状态
 * @author zhangqi61
 * @since 2022/4/24
 */
private const val TAG = "CoroutineNoShareState"

/**
 * 多线程操作一个共享的变量导致线程不安全的问题
 * 那么就在多线程中不共享这个变量，
 * 换一种思想
 * @return Int
 */
fun noShareState() = runBlocking {
    val deferredList = mutableListOf<Deferred<Int>>()

    repeat(10) {
        val deferred = async(Dispatchers.Default) {
            var i = 0
            repeat(1000) {
                i++
            }
            return@async i
        }
        deferredList.add(deferred)
    }

    var result = 0
    deferredList.forEach {
        result += it.await()
    }

    Log.d(TAG, "result is $result")
}

/**
 * 不共享可变的变量，最终获取到线程的结果
 * @return Int 结果值
 */
fun noShareStateMethod() = runBlocking {
    val result = (1..10).map {
        async(Dispatchers.Default) {
            var i = 0
            repeat(1000) {
                i++
            }
            return@async i
        }
    }.awaitAll()
        .sum()

    Log.d(TAG, "result is $result")
}

fun mapOperate() {
    (1..10).map {
        it * 2
    }.forEach {
        Log.d(TAG, "it = $it")
    }
}