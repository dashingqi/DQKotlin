package com.dashingqi.inlines

/**
 * inline关键字
 * @author zhangqi61
 * @since 2022/10/21
 * inline关键字的作用就是将inline函数当中的代码拷贝到调用处；
 * inline用于高阶函数上时，才会有显著的性能提升；
 * 总结：inline关键字更适合用于通用功能的高阶函数
 *
 * noinline
 *
 * 函数函数风格：函数的扩展
 */

inline fun foo(block: () -> Unit) {
    block.invoke()
}

fun main() {
    var i = 0
    foo {
        i++
    }
}