package com.dashingqi.dqkotlin.interfaces

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/21 22:40
 */
interface Behavior {
    val canWalk: Boolean

    var canIs : Boolean

    // 接口中的方法可以有默认实现
   fun walk() {
        if (canWalk) {
            // doSomething
        }
    }
}