package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.dqkotlin.extend.Person
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

        val person = Person(20, "DashingQi")
        var adult = person.isAdult
        val max = person.isMax
        Log.d(TAG, "max is $max ")
        person.age = 17
        val templateMax = person.isMax
        Log.d(TAG, "templateMax is $templateMax");

    }

}