package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread {
            Runnable {
                println("current thread is ${Thread.currentThread().name}")
            }.run()
        }
    }

}