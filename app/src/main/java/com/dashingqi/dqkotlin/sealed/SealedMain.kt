package com.dashingqi.dqkotlin.sealed

/**
 * @author zhangqi61
 * @since 2021/12/27
 */
fun main() {

    val man = Person.MAN
    val women = Person.WOMEN
    println("${man == women}")


    when (val item: SealedClass = getSealedClass()) {
        is Java -> {
        }

        is JavaScript -> {

        }
    }
}

fun getSealedClass(): SealedClass {
    return Java("java")
}