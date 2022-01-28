package com.dashingqi.dqkotlin.objects

/** 抽象类模版
 * @author zhangqi61
 * @since 2022/1/28
 */
abstract class BaseSingleton<in P, out T> {
    @Volatile
    private var instance: T? = null
    protected abstract fun creator(param: P): T
    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(param).also { instance = it }
        }
}