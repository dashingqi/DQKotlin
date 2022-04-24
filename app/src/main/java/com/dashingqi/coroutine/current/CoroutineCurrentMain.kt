package com.dashingqi.coroutine.current

import android.util.Log
import kotlinx.coroutines.*
import java.util.concurrent.Executors

/**
 * @desc : 协程也需要处理多线程同步问题
 * @author : zhangqi
 * @time : 2022/4/17 17:00
 */

private const val TAG = "CoroutineCurrentMain"

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
    val lock = Any()

    repeat(10) {
        val job = launch(Dispatchers.Default) {
            Log.d(TAG, "Current thread is ${Thread.currentThread().name}")
            repeat(1000) {
                synchronized(lock) {
                   // prepare()
                    i++
                }
            }
        }
        jobs.add(job)
    }

    jobs.joinAll()
    println("i = $i")
}

/**
 * synchronized 中不能使用 挂起函数
 */
suspend fun prepare(){

}

fun coroutineJobsInThread() = runBlocking {
    val mySingleDispatcher = Executors.newSingleThreadExecutor {
        Thread(it, "MySingleThread").apply { isDaemon = true }
    }.asCoroutineDispatcher()

    var i = 0
    val jobs = mutableListOf<Job>()
    repeat(10) {
        val job = launch(mySingleDispatcher) {
            println("Current thread is ${Thread.currentThread().name}")
            repeat(1000) {
                i++
            }
        }
        jobs.add(job)
    }
    jobs.joinAll()
    Log.d(TAG, "i = $i")
}