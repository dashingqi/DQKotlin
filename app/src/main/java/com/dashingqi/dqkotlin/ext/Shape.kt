package com.dashingqi.dqkotlin.ext

/**
 * @author zhangqi61
 * @since 2022/1/6
 */
open class Shape

class Rectangle : Shape()

fun Rectangle.getName() = "Rectangle"

fun Shape.getName() = "shape"

fun printClassName(s: Shape) {
    println("name is ${s?.getName()}")
}
