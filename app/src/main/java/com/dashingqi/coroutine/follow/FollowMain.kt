package com.dashingqi.coroutine.follow

import android.util.Log
import com.dashingqi.coroutine.channel.logX
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 练习使用follow
 * @author zhangqi61
 * @since 2022/4/15
 */
private const val TAG = "FollowMain"
suspend fun flowOnCompletion() {
    flowOf(1, 2, 3, 4)
        .filter { it > 0 }
        .onCompletion {
            Log.d(TAG, "onCompletion result is $it ")
        }
        .collect {
            Log.d(TAG, "collect result is $it")
            if (it == 2) {
                Log.d(TAG, "cancel")
            }
        }
}

suspend fun flowOn() {
    flowOf(1, 2, 3, 4, 5)
        .filter {
            logX("filter is $it")
            it > 1
        }
        // 将该位置以上的代码放到子线程中进行处理
        .flowOn(Dispatchers.IO)
        .collect {
            logX("Collect is $it")

        }
}

suspend fun launchIn() {
    val scope = CoroutineScope(EmptyCoroutineContext)
    flowOf(1, 2, 3, 4, 5, 6)
        .filter {
            logX("filter result is $it")
            it > 1
        }
        .flowOn(Dispatchers.IO)
        .map {
            logX("map result is $it")
            it * 2
        }
        .take(2)
        .onEach {
            logX("each result is $it")
        }
        .launchIn(scope)
}

suspend fun withContextFlow() {
    flow {
//        withContext(Dispatchers.IO) {
//            emit(1)
//        }
        emit(1)
    }
        .map {
            it * 2
        }
        .collect {
            logX("Result is $it")
        }
}

