package com.dashingqi.dqkotlin

/**
 * @author zhangqi61
 * @since 2021/12/21
 */

fun arrayMethod() {
    val array = arrayOf(1, 2, 3)
    array.forEach {
        print("it is $it")
    }

    // 使用 indices 遍历数组
    for (index in array.indices) {
        println("indices index is $index")
    }
//    反编译后 处理创建一些临时变量，没有创建额外对象
//    int var1 = 0;
//    for(int var11 = array.length; var1 < var11; ++var1) {
//    }

    //使用 ..

    for (index in 0..array.size) {
        println(" .. index is $index")
    }

    // 使用 downTo
    for (index in array.size downTo 0) {
        println("downTo is $index")
    }

    // 左闭右开
    for (index in 0 until array.size) {
        println("until index is $index")
    }
}
