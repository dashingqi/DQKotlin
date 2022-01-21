package com.dashingqi.dqkotlin.interfaces

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/21 22:47
 */
class BehaviorImpl(override var canIs: Boolean) : Behavior {

    // 重写 canWalk属性
    override val canWalk: Boolean
        get() = true
}