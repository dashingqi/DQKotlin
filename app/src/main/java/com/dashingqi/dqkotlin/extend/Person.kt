package com.dashingqi.dqkotlin.extend

/**
 * @author zhangqi61
 * @since 2022/1/21
 */
open class Person(private val age: Int, var name: String) {
    //    fun isAdult() = age > 18
    // 将isAdult 变成Person的属性
    val isAdult
        get() = age > 19

    // 该情况下自动类型推导会失效，需要声明一下类型
    val isMe: Boolean
        get() {
            print("")
            return age > 18
        }

    // 这种代码无法正常工作
    val isAdult2 = age > 19

    var length: Int = 180
        // 这是length属性的setter的方法
        // private 表示限制在类内部访问
        private set(value: Int) {
            print("")
            field = value
            print("")
        }

    // 声明成open 才能被子类重写
    open fun doSomething() {

    }
}