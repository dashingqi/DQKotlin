package com.dashingqi.dqkotlin.sealed

/**
 * 密封类
 * @author zhangqi61
 * @since 2021/12/27
 */

/**
 * kotlin1.0时的密封类
 * 子类型必须是密封类的内部类
 */
//sealed class SealedClass {
//    class Java(ver: String) : SealedClass()
//    class JavaScript(ver: String) : SealedClass()
//}

///**
// * kotlin 1.1时的密封类
// * 取消了子类必须在密封类内部定义的约束，
// * 当为了保证编译的同步 仍然需要在同一文件中
// */
//sealed class SealedClass
//class Java(ver: String) : SealedClass()
//class JavaScript(ver: String) : SealedClass()

/**
 * kotlin 1.5 再次放宽
 * 允许子类可以定义在不同的文件中，
 * 只要保证子类和父类在同一个module且是同一个包名下就可以
 */
sealed class SealedClass