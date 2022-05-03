package com.dashingqi.coroutine.exception

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/**
 * @author zhangqi61
 * @since 2022/4/25
 */

val fixedDispatcher = Executors.newFixedThreadPool(2) {
    Thread(it, "MyFixedThread").apply { isDaemon = true }
}.asCoroutineDispatcher()

fun structMain() = runBlocking {
    val parentJob = launch(fixedDispatcher) {
        // 第一个协程
        launch(Job()) {
            var i = 0
            while (isActive) {
                Thread.sleep(500L)
                i++
                println(" First i == $i")
            }
        }

        launch {
            var i = 0
            while (isActive) {
                Thread.sleep(500L)
                i++
                println(" Second i == $i")
            }
        }
    }

    delay(2000L)
    // 协程是具有结构化功能，意思就是 协程中开启协程，称为子协程，当父协程被取消后，内部开启的子协程就会被取消
    parentJob.cancel()
    parentJob.join()
    println("End")
}

fun supervisorJobMethod() = runBlocking {
    // 使用了SupervisorJob创建的协程，，不调用await()方法 async{}内部的代码出现异常也不会crash
    val scope = CoroutineScope(SupervisorJob())
    val deferred = scope.async {
        println("perform async")
        delay(100L)
        1 / 0
    }
    try {
        deferred.await()
    } catch (exception: Exception) {
        println("Catch : $exception")
    }

    delay(500L)
    println("end")
}