package com.dashingqi.dqkotlin.objects

/**
 * @author zhangqi61
 * @since 2022/1/28
 */

interface A {
    fun funA()
}

interface B {
    fun funB()
}

abstract class Man {
    abstract fun findMan()
}

fun main() {
    val item = object : Man(), A, B {
        override fun findMan() {
        }

        override fun funA() {

        }

        override fun funB() {

        }
    }
}

