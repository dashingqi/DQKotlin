package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.http.HttpV1
import com.dashingqi.http.HttpV2
import com.dashingqi.service.ApiService
import com.dashingqi.service.WanAndroidService
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
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
    }

}