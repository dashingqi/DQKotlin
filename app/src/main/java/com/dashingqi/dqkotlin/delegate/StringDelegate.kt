package com.dashingqi.dqkotlin.delegate

import kotlin.reflect.KProperty

/**
 * @desc : 委托属性
 * @author : zhangqi
 * @time : 2022/1/8 16:23
 */
class StringDelegate(private var s: String = "hello") {

    operator fun getValue(thisRef: Any, property: KProperty<*>): String {
        return s
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        s = value
    }
}