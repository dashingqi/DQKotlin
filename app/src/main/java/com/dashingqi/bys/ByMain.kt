package com.dashingqi.bys

import android.util.Log
import android.widget.TextView
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * kotlin中的委托
 * @author zhangqi61
 * @since 2022/10/21
 */

// 委托类
interface DB {
    fun save()
}

class SQLiteDB : DB {
    override fun save() {
        Log.d("TAG", "SQLiteDB perform ")
    }
}

class GreenDaoDB : DB {
    override fun save() {
        Log.d("TAG", "GreenDaoDB perform ")
    }
}

class UniversalDB(db: DB) : DB by db

// 委托属性

class Item {
    // 将属性total委托给了属性count
    var count: Int = 0

    // ::count 是属性的引用
    var total: Int by ::count
}

class Items {
    var count: Int = 0

    var total: Int
        get() = count
        set(value) {
            count = value
        }
}

// 懒加载委托
// 就是对于需要消耗计算机资源的操纵，我们希望被访问时才去触发

// 自定义委托
// kotlin提供 ReadWriteProperty、ReadOnlyProperty接口来自定义委托
// 如果是val属性自定义委托，就使用ReadOnlyProperty这个接口；
// 使用这两个接口，编译器可以帮助我们自动实现get和set方法

class StringDelegate(var s: String = "Dashingqi") : ReadWriteProperty<Owner, String> {
    override fun getValue(thisRef: Owner, property: KProperty<*>): String {
        return s
    }

    override fun setValue(thisRef: Owner, property: KProperty<*>, value: String) {
        s = value
    }

}

class Owner {
    var text: String by StringDelegate()
    var normalText: String by SmartDelegator()
    var logText: String by SmartDelegator()
}

// 提供委托

// 要想在属性委托之前再做一些额外的判断工作，我们可以使用provideDelegate实现
class SmartDelegator {
    // 使用provideDelegate来嵌套Delegator
    operator fun provideDelegate(thisRef: Owner, property: KProperty<*>): ReadWriteProperty<Owner, String> {
        return if (property.name.contains("log")) {
            StringDelegate("log")
        } else {
            StringDelegate("normal")
        }
    }
}


// 属性可见性封装
class Model {
    // 将属性data的set方法声明为private时，data属性只能在类的内部进行访问，外部无法修改data的值
    var data: String = ""
        private set

    // 类的外部通过Model的实例还是能够获取到dataList的实例，调用add方法来操作它
    // val dataList = mutableListOf<String>()

    // List是kotlin当中不可修改的List，它是没有 add 、remove等方法
    // 我们通过属性委托，将data委托给了_data
    // _data是可变集合并且是private，只能在类的内部进行访问
    // 这样dataList只能作为类外访问获取数据的接口，不能直接操作
    // 类型_data是进行集合变更的集合
    val dataList: List<String> by ::_data
    private val _data = mutableListOf<String>()


    private fun load() {
        data = "请求结果"
        _data.add("DashingQi")
    }
}

fun delegateMain() {
    val model = Model()
    model.dataList.size
}

// 数据与View的绑定
// provideDelegate() 提供委托
operator fun TextView.provideDelegate(value: Any?, property: KProperty<*>) = object : ReadWriteProperty<Any?, String?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        return text?.toString()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        text = value
    }

}





























































