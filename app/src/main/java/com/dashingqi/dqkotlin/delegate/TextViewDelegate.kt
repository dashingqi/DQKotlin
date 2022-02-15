package com.dashingqi.dqkotlin.delegate

import android.widget.TextView
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author zhangqi61
 * @since 2022/2/15
 */

operator fun TextView.provideDelegate(value: Any?, property: KProperty<*>) =
    object : ReadWriteProperty<Any?, String?> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): String? = text?.toString()

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
            text = value
        }

    }