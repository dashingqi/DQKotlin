package com.dashingqi.coroutine.current

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * @desc : Mutex
 * @author : zhangqi
 * @time : 2022/4/23 10:48
 */

fun coroutineMutexMain() = runBlocking {
    val mutex = Mutex()
    var i = 0
    val jobs = mutableListOf<Job>()

    repeat(10) {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                mutex.withLock {
                    i++
                }
            }
        }
        jobs.add(job)
    }

    jobs.joinAll()
    println("i == $i")

}