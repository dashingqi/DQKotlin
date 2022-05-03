package com.dashingqi.coroutine.exception

import kotlinx.coroutines.*

/**
 * @desc : kotlin协程处理异常
 * @author : zhangqi
 * @time : 2022/4/25 08:03
 * kotlin协程是相互协助的程序
 * 1. 协程的取消需要内部的配合
 */

fun coroutineException() = runBlocking {

    val job = launch(Dispatchers.Default) {
        var i = 0
        while (isActive) {
            Thread.sleep(500L)
            i++
            println("i = $i")
        }
    }
    delay(2000L)
    job.cancel()
    job.join()
    println("End")

}