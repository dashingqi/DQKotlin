package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dashingqi.dqkotlin.delegate.LogList
import com.dashingqi.dqkotlin.delegate.SQLDB
import com.dashingqi.dqkotlin.delegate.UniversalDB
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread {
            Runnable {
                println("current thread is ${Thread.currentThread().name}")
            }.run()
        }

        UniversalDB(SQLDB()).save()

        val list = mutableListOf("1", "2")
        LogList(list) {
            // do Something
        }.getAndLog(1)
    }
}