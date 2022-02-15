package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dashingqi.dqkotlin.delegate.LogList
import com.dashingqi.dqkotlin.delegate.SQLDB
import com.dashingqi.dqkotlin.delegate.UniversalDB
import com.dashingqi.dqkotlin.delegate.provideDelegate
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val delegateTextView = findViewById<TextView>(R.id.delegate_textview)
        var message: String? by delegateTextView

        delegateTextView.text = "Hello"
        println("message is $message")

        message = "World"
        println("text is ${delegateTextView.text}")
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