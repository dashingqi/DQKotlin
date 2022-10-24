package com.dashingqi.generics

/**
 * 协变 逆变
 * @author zhangqi61
 * @since 2022/10/24
 *
 * 程序是将现实生活进行抽象
 * 我们的范性是对程序的抽象
 *
 * 本来写程序就是一件比较抽象的事情，范性就更加抽象，不太好理解
 *
 * 上界：
 * 下界：
 *
 * 父子关系颠倒的现象:逆变 如果A是B的子类，那么Generics<A>是Generics<B>的父类
 * 父子关系一致的现象:协变 如果A是B的子类，那么Generics<A> 也是Generics<B>的子类
 *
 */


/** 打开*/
fun <T> turnOn(t: T) {}

/** 关闭*/
fun <T> turnOff(t: T) {}

open class TV {
    open fun turnOn() {}
    open fun turnOff() {}
}

class XiaoMiTv1 : TV() {
    override fun turnOff() {
        super.turnOff()
    }

    override fun turnOn() {
        super.turnOn()
    }
}

// 声明处型变（声明处逆变）
class TVController<in T : TV> {
    fun turnOn(t: T) {
        t.turnOn()
    }
}

fun realMain() {
    val tvController = TVController<XiaoMiTv1>()
    buy(tvController)

    val kfcRestaurant = Restaurant<KFC>()
    orderFood(kfcRestaurant)
}

// 使用处型变（使用处逆变）
fun buy(controller: TVController<XiaoMiTv1>) {
    val xiaomiTv = XiaoMiTv1()
    controller.turnOn(xiaomiTv)
}


open class Food {}

class KFC : Food() {}

// 声明处协变
class Restaurant<out T : Food> {
    fun orderFood(): T {
    }
}

// 使用处协变
fun orderFood(restaurant: Restaurant<Food>) {
    val food: Food = restaurant.orderFood()
}
// 星投影
// 用星号作为泛型的实参，当我们不关心实参到底是什么类型的时候；



