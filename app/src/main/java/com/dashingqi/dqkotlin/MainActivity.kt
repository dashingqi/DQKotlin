package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.coroutine.current.coroutineCurrent
import com.dashingqi.coroutine.current.coroutineCurrentJobs
import com.dashingqi.coroutine.follow.launchIn
import com.dashingqi.coroutine.follow.onFlowCatch
import com.dashingqi.coroutine.follow.onFlowLifecycle
import com.dashingqi.coroutine.follow.withContextFlow
import com.dashingqi.coroutine.select.cancelAllDeferred
import com.dashingqi.coroutine.select.selectChannelMethod
import com.dashingqi.coroutine.select.selectMethod
import com.dashingqi.http.HttpV2
import com.dashingqi.service.ApiService
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread {
            Runnable {
                Log.d(TAG, "current thread is ${Thread.currentThread().name} ")

                val wanAndroidService = HttpV2.create<ApiService>()
                val wxArticle = wanAndroidService.repos(lang = "kotlin", since = "weekly")
                Log.d(TAG, "wxArticle data is ${wxArticle?.msg}")
            }.run()
        }

        runBlocking {
//            onFlowLifecycle()
//            onFlowCatch()
//            selectMethod()
            //selectChannelMethod()
//            selectChannelMethod()
//            cancelAllDeferred()
//            coroutineCurrent()
            coroutineCurrentJobs()
        }

        val result = kotlin.runCatching {
            val i = 3
            6
        }
        result.onFailure {
            Log.d(TAG, "onFailure perform  exception is $it")
        }
        result.onSuccess {
            Log.d(TAG, "onSuccess perform result is $it")
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}