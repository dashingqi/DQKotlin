package com.dashingqi.bys

import android.util.Log

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

