package com.dashingqi.dqkotlin.objects

/**
 * 双重检查模式
 * @author zhangqi61
 * @since 2022/1/28
 */
class UserManager private constructor(name: String) {
//    companion object {
//        @Volatile
//        private var INSTANCE: UserManager? = null
//        fun getInstance(name: String): UserManager =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: UserManager(name)?.also {
//                    INSTANCE = it
//                }
//            }
//    }

    companion object : BaseSingleton<String, UserManager>() {
        override fun creator(param: String): UserManager {
            return UserManager(param)
        }
    }
}