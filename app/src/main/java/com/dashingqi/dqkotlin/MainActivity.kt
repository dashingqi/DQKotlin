package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.dashingqi.coroutine.current.coroutineCurrent
import com.dashingqi.coroutine.current.coroutineCurrentJobs
import com.dashingqi.coroutine.current.coroutineJobsInThread
import com.dashingqi.coroutine.current.coroutineMutexMain
import com.dashingqi.coroutine.follow.launchIn
import com.dashingqi.coroutine.follow.onFlowCatch
import com.dashingqi.coroutine.follow.onFlowLifecycle
import com.dashingqi.coroutine.follow.withContextFlow
import com.dashingqi.coroutine.select.cancelAllDeferred
import com.dashingqi.coroutine.select.selectChannelMethod
import com.dashingqi.coroutine.select.selectMethod
import com.dashingqi.http.HttpV2
import com.dashingqi.service.ApiService
import com.hjq.xtoast.XToast
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val runnable = Runnable {
            XToast<XToast<*>>(this)
                .apply {
                    setContentView(R.layout.layout_toast_hint)
                    setText(R.id.message, "点我消失")
                    setDuration(1000)
                    setOnClickListener(
                        R.id.message,
                        XToast.OnClickListener<TextView?> { toast: XToast<*>, view: TextView? ->
                            toast.cancel()

                        })

                }
                .show()
        }
        findViewById<TextView>(R.id.hl).postDelayed(runnable, 6000)
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
            //coroutineCurrentJobs()
            coroutineMutexMain()
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

        findViewById<TextView>(R.id.hl).setOnClickListener {
            AlertDialog
                .Builder(this)
                .setTitle("测试测试")
                .setMessage("这是一个严肃的测试")
                .setCancelable(false)
                .setPositiveButton("弹出Toast") { dialog, which ->

                }
                .setNegativeButton("弹出Toast") { dialog, which ->
                    XToast<XToast<*>>(this)
                        .apply {
                            setContentView(R.layout.layout_toast_hint)
                            setText(R.id.message, "点我消失")
                            setDuration(1000)
                            setOnClickListener(
                                R.id.message,
                                XToast.OnClickListener<TextView?> { toast: XToast<*>, view: TextView? ->
                                    toast.cancel()

                                })

                        }
                        .show()
                }
                .show()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}