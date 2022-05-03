package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun fun1(num: Int): Double {
        return num.toDouble()
    }

    // 函数引用
    val f1: (Int) -> Double = ::fun1

    fun CoroutineScope.fun2(num: Int): Double {
        return num.toDouble()
    }

    val f2: CoroutineScope.(Int) -> Double = CoroutineScope::fun2

    suspend fun fun3(num: Int): Double {
        return num.toDouble()
    }

    val f3: suspend (Int) -> Double = ::fun3
}