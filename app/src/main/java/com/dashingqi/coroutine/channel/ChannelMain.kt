package com.dashingqi.coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author zhangqi61
 * @since 2022/4/11
 */

fun channelMain() = runBlocking {
    val channel = Channel<Int>()

    launch {
        (1..3).forEach {
            channel.send(it)
            logX("Send $it")
        }
    }

    launch {
        for (i in channel) {
            logX("Receive $i")
        }
    }
}

fun logX(any: Any?) {
    println(
        """
==================================
$any
Thread:${Thread.currentThread().name}
==================================        
    """.trimIndent()
    )
}