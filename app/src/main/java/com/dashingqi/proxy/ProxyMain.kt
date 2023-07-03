package com.dashingqi.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 静态代理
 * @author zhangqi61
 * @since 2022/10/27
 * 代理模式可以在不修改对象的基础上，通过扩展代理类，进行一些功能的附件于增强
 *
 * 动态代理
 * 在运行时编译器自动帮助我们生成一个实现Movie接口的类（等同于我们手动编写的Cinema类）
 */

fun proxyMain() {
    val movie = RealMovie()
    val cinema = Cinema(movie)
    cinema.play()

    Proxy.newProxyInstance(Thread.currentThread().contextClassLoader, arrayOf(Movie::class.java), object
        : InvocationHandler {
        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
            TODO("Not yet implemented")
        }

    })
}