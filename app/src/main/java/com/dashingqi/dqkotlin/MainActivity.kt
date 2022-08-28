package com.dashingqi.dqkotlin

import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColorInt
import com.dashingqi.coroutine.exception.coroutineException
import com.dashingqi.coroutine.current.*
import com.dashingqi.coroutine.exception.structMain
import com.dashingqi.coroutine.exception.supervisorJobMethod
import com.dashingqi.http.HttpV2
import com.dashingqi.service.ApiService
import com.hjq.xtoast.XToast
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapOperate()

        val bitmap = Bitmap.createBitmap(50, 60, Bitmap.Config.ARGB_8888)
        bitmap.toDrawable(resources)

        val drawable = ColorDrawable("#FF0000".toColorInt())
        drawable.toBitmap()

//        val runnable = Runnable {
//            XToast<XToast<*>>(this)
//                .apply {
//                    setContentView(R.layout.layout_toast_hint)
//                    setText(R.id.message, "点我消失")
//                    setDuration(1000)
//                    setOnClickListener(
//                        R.id.message,
//                        XToast.OnClickListener<TextView?> { toast: XToast<*>, view: TextView? ->
//                            toast.cancel()
//
//                        })
//
//                }
//                .show()
//        }
//        findViewById<TextView>(R.id.hl).postDelayed(runnable, 6000)
//        thread {
//            Runnable {
//                Log.d(TAG, "current thread is ${Thread.currentThread().name} ")
//
//                val wanAndroidService = HttpV2.create<ApiService>()
//                val wxArticle = wanAndroidService.repos(lang = "kotlin", since = "weekly")
//                Log.d(TAG, "wxArticle data is ${wxArticle?.msg}")
//            }.run()
//        }

        runBlocking {
//            onFlowLifecycle()
//            onFlowCatch()
//            selectMethod()
            //selectChannelMethod()
//            selectChannelMethod()
//            cancelAllDeferred()
//            coroutineCurrent()
            //coroutineCurrentJobs()
//            coroutineMutexMain()
//            actorMain()
//            noShareState()
//            noShareStateMethod()
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

        coroutineException()

        supervisorJobMethod()

    }

    companion object {
        private const val TAG = "MainActivity"
    }

}