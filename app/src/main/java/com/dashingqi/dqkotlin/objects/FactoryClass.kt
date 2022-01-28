package com.dashingqi.dqkotlin.objects

/**
 * @author zhangqi61
 * @since 2022/1/28
 */
class FactoryClass private constructor(name: String) {
    companion object {
        @JvmStatic
        fun create(name: String): FactoryClass {
            return FactoryClass(name)
        }

    }
}