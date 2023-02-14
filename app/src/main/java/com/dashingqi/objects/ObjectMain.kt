package com.dashingqi.objects

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull

/**
 * 单例
 * @author zhangqi61
 * @since 2022/10/19
 * 存在的缺点
 * 1. 不支持懒加载
 * 2. 不支持传参数构造单例
 */
object ObjectMain {
    fun findMain() {

    }
}

class Man {
    object InnerSingleton {
        fun findMan() {

        }
    }
}

class Person {
    // 指定伴生对象，默认类名为Companion，此时类名为InnerSingleton
    companion object InnerSingleton {
        @JvmStatic
        fun foo() {

        }
    }
}

class User private constructor(name: String) {
    companion object {
        @JvmStatic
        fun create(name: String): User {
            return User(name)
        }
    }
}

// Double Check

class UserManager private constructor(name: String) {
    companion object {
        @Volatile
        private var instance: UserManager? = null
        fun getInstance(name: String): UserManager = instance ?: synchronized(this) {
            instance ?: UserManager(name).also { instance = it }
        }
    }
}

class PersonManager private constructor(var name: String) {
    companion object : BaseSingleton<String, PersonManager>() {
        override val creator: (String) -> PersonManager
            get() = ::PersonManager
    }

    fun managePerson() {
        Log.d("PersonManager", "name is $name")
    }
}

// 抽象 Double check 模版
abstract class BaseSingleton<in P, out T> {

    @Volatile
    private var instance: T? = null

    // 需要实现
    abstract val creator: (P) -> T

    @NonNull
    fun getInstance(params: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(params)
        }
}

fun testContext(context:Context){

}

