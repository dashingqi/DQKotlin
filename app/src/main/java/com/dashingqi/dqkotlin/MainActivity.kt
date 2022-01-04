package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.dashingqi.dqkotlin.sealed.Java
import com.dashingqi.dqkotlin.sealed.Person
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printPeople(People("张琦", "北京"))
        joinToStringMethod()
        handleString("")
        arrayMethod()
        plusMethod()
        requireMethod()
        method()
        enumMethod()
        sealedClassMethod()

        println("result is ${lock("dashingqi", "zhangqi", ::getResult)}")



        thread {
            Runnable {
                println("current thread is ${Thread.currentThread().name}")
            }.run()
        }
    }

    // 解构声明不要和数据类一起使用
    private fun printPeople(people: People) {
        val (name, city) = people
        println("name is $name")
        println("city is $city")
    }

    private fun joinToStringMethod() {
        val data = listOf("java", "kotlin", "c++", "c")
            .joinToString(
                separator = " | ",
                prefix = "{",
                postfix = "}"
            )
        val arrayData = arrayOf("java", "kotlin", "c++", "c")
            .joinToString(
                separator = " | ",
                prefix = "{",
                postfix = "}"
            )

        println(arrayData)
        println(data)

        val data2 = "**hi zq**"
        // 移除前缀
        println(data2.removePrefix("**"))
        //移除后缀
        println(data2.removeSuffix("**"))
        //移除前缀和后缀
        println(data2.removeSurrounding("**"))
        // 返回第一次出现分割后的字符串
        println(data2.substringAfter("**"))
        //如果没有找到，返回原始字符串
        println(data2.substringAfter("--"))
        // 如果没有找到，返回默认字符串
        println(data2.substringAfter("--", "DashingQi"))
    }

    private fun handleString(target: String) {
        // 优雅处理字符串为空的情况
        val name = target.ifEmpty { "str" }
        println("name is $name")
        try {
            val input = "123asd"
            // 这个转换存在一定的问题，当input包含其他非数字字符会有问题
            // val toInt = input.toInt()
            // 优雅处理 字符串转数字的操作
            val intResult = input.toIntOrNull() ?: 0
            println("intResult is $intResult")
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    private fun plusMethod() {
        val maps = mapOf<String, String>("0" to "Java").withDefault {
            println("it --> $it")
            "DashingQi"
        }
//        val currentMaps = maps + Pair("1", "Kotlin")
//        println("currentMaps --> $currentMaps")
        val currentC = maps.getValue("c++")
        println("currentC ---> $currentC")

    }

    private fun withDefaultMethod() {
        val maps = mapOf<String, String>("0" to "Java").withDefault {
            println("it --> $it") // c++
            "DashingQi"
        }
        val currentC = maps.getValue("c++")
        println("currentC ---> $currentC")
    }

    private fun requireMethod() {
        // checkAge(-1)
    }

    private fun checkAge(age: Int) {
        require(age > 0) {
            "age must not be negative"
        }
    }

    private fun checkNotNullMethod(message: String?) {
        checkNotNull(message) {
            "name must not be null"
        }
    }

    private fun method() {
        var name: String? = null

        // also 是返回调用自身
        val subName = name.also {
            "DashingQi"
            name = "Dashingqi"
        }

        println("subName is $subName")

        // let 返回最后一行的值
        val subName2 = name.let {
            "DashingQi"
        }
        println("subName2 is $subName2")
    }

    private fun enumMethod() {
        val women = Person.WOMEN
        val man = Person.WOMEN
        println("enum boolean  ${women == man}")
    }

    private fun sealedClassMethod() {
        val java = Java("2")
        val java1 = Java("2")
        println("sealed classes is ${java == java1}") // false
    }

    private fun getResult(str: String, str2: String): String = "result is {$str , $str2}"

    private fun lock(str: String, str2: String, method: (str: String, str2: String) -> String): String {
        return method.invoke(str, str2)
    }
}