package com.dashingqi.coroutine.current

import kotlinx.coroutines.*

/**
 * @desc : 协程也需要处理多线程同步问题
 * @author : zhangqi
 * @time : 2022/4/17 17:00
 */

fun coroutineCurrent() = runBlocking {
    var i = 0
    launch(Dispatchers.Default) {
        repeat(1000) {
            i++
        }
    }

    delay(1000L)
    println("i = $i")
}

fun coroutineCurrentJobs() = runBlocking {
    var i = 0
    val jobs = mutableListOf<Job>()

    repeat(10) {
        val job = launch(Dispatchers.Default) {
            println("Current thread is ${Thread.currentThread().name}")
            repeat(1000) {
                i++
            }
        }
        jobs.add(job)
    }

    jobs.joinAll()

    println("i = $i")
}