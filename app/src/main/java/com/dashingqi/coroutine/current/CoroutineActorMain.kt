package com.dashingqi.coroutine.current

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor

/**
 * Actor的使用
 * @author zhangqi61
 * @since 2022/4/24
 */
private const val TAG = "CoroutineActorMain"

sealed class Msg
object AddMsg : Msg()

class ResultMsg(
    val result: CompletableDeferred<Int>
) : Msg()

fun actorMain() = runBlocking {

    suspend fun addActor() = actor<Msg> {
        var counter = 0
        for (msg in channel) {
            when (msg) {
                is AddMsg -> counter++
                is ResultMsg -> msg.result.complete(counter)
            }
        }
    }

    val actor = addActor()
    val jobs = mutableListOf<Job>()

    repeat(10) {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                actor.send(AddMsg)
            }
        }
        jobs.add(job)
    }

    jobs.joinAll()

    val deferred = CompletableDeferred<Int>()
    actor.send(ResultMsg(deferred))

    val result = deferred.await()
    actor.close()

    Log.d(TAG, "result == $result")
}

