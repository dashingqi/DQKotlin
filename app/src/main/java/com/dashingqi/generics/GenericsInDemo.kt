package com.dashingqi.generics

/**
 * @desc : in --> 【逆变】
 * @author : zhangqi
 * @time : 2023/7/29 15:47
 */


open class TV {
    open fun turnOn() {}
    open fun turnOff() {}
}


// 声明处逆变
class Controller<T : TV> {
    fun turnOn(tv: T) {
        tv.turnOn()
    }
}

// 使用处逆变
fun buy(controller: Controller<in XiaoMiTv1>) {
    val xiaoMiTv1 = XiaoMiTv1()
    controller.turnOn(xiaoMiTv1)
}

fun tvMain() {
    // 万能遥控器 能控制任何电视的
    val controller = Controller<TV>()
    buy(controller)
}
