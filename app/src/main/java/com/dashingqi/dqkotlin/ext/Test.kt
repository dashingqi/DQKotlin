package com.dashingqi.dqkotlin.ext

/**
 * 类内扩展
 * @author zhangqi61
 * @since 2022/1/5
 */
class Test(val host: Host, val port: Int) {

    private fun printPort() {
        println("port is $port")
    }

    fun Host.printConnectionString() {
        printHostName()
        println(":")
        printPort()
    }

    val Host.isHomeEmpty: Boolean
        get() = hostName.isEmpty()
}