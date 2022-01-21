package com.dashingqi.dqkotlin.nest

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/21 23:00
 */
class A {

    val name: String = "A"
    fun method() = 2

     inner class B {
        val bName = name
        val bMethod = method()
    }
}