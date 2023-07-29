package com.dashingqi.generics

import android.util.Log

/**
 * @desc : 协变【out】
 * @author : zhangqi
 * @time : 2023/7/29 14:32
 */

abstract class Food {
    abstract fun start()
    abstract fun prepare()
}
class KFC : Food() {
    override fun start() {
        Log.d(this::class.java.name, " make start");
    }

    override fun prepare() {
        Log.d(this::class.java.name, " make start");
    }
}
class Restaurant<out T : Food>(private val t: T) {
    fun orderFood(): T {
        t.prepare()
        t.start()
        return t
    }
}

// 使用处型变（协变）
// 不声明 out 关键字 此时编译器会提示 需要Restaurant<Food>类型 而你传入的是Restaurant<KFC>
// 使用out关键字之后，就有了继承的关系在里面 Restaurant<KFC>:Restaurant<Food>
fun orderFood(restaurant: Restaurant<Food>) {
    val food = restaurant.orderFood()
}

fun outMain() {
    // 声明一个能做KFC的饭馆
    val kfc = Restaurant(KFC())
    orderFood(kfc)
    val findRestaurant = findRestaurant()
    var orderFood = findRestaurant.orderFood()
}
