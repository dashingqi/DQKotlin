package com.dashingqi.dqkotlin.sealed

/**
 * @author zhangqi61
 * @since 2021/12/27
 */
//enum class Color(var value: Int) {
//    RED(1),
//    GREEN(2)
//}

sealed class SealedColor(var value: Int) {
//    // 在Sealed Classes内部中使用object声明时，我们可以重用他们，不需要每次都要重新创建一个实例
//    // 当这样使用的时候其实和枚举一样的，这种情况使用枚举时更合适的；
//    object RED : SealedColor(1)
//    object YELLOW : SealedColor(2)
//    object GREEN : SealedColor(3)
}