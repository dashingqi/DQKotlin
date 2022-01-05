package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("result is ${lock("dashingqi", "zhangqi", ::getResult)}")



        thread {
            Runnable {
                println("current thread is ${Thread.currentThread().name}")
            }.run()
        }
    }

    private fun getResult(str: String, str2: String): String = "result is {$str , $str2}"

    private fun lock(str: String, str2: String, method: (str: String, str2: String) -> String): String {
        return method.invoke(str, str2)
    }
}