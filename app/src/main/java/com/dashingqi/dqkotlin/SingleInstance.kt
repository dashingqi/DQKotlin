package com.dashingqi.dqkotlin

/**
 * @desc : 单例的实现
 * @author : zhangqi
 * @time : 2021/12/25 15:57
 */

// 使用Object关键字

object WorkSingleton {

}

// 使用 by lazy关键字 利用伴生对象和 by lazy 实现单例

class WorkSingleInstance private constructor() {


    companion object {
        // 方式1
        val INSTANCE1 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            WorkSingleInstance()
        }

        // 默认的mode就是 LazyThreadSafetyMode.SYNCHRONIZED
        val INSTANCE2 by lazy {
            WorkSingleInstance()
        }
    }
}

class WorkSingleInstance2 private constructor() {

    companion object {
        fun get(): WorkSingleInstance2 {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = WorkSingleInstance2()
    }
}

class WorkSingleInstance3 private constructor() {

    companion object {
        fun get(): WorkSingleInstance3 {
            return WorkSingleInstance3()
        }
    }

}

