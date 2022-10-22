package com.dashingqi.funs

import android.view.View

/**
 * 高阶函数
 * @author zhangqi61
 * @since 2022/10/20
 */

// 这样就不需要定义接口了
var mOnClickListener: ((View) -> Unit)? = null

fun setOnClickListeners(l: (View) -> Unit) {
    mOnClickListener = l
}

// 定义一个正常的函数
fun add(a: Int, b: Int, view: View): Int {
    mOnClickListener?.invoke(view)
    return 0
}

// 函数的类型：就是将一个方法的参数类型和方法的返回值类型抽象出来称为函数的类型

// ::add 函数的引用
val function: (Int, Int, View) -> Int = ::add

// 高阶函数就是将函数用作参数或者返回值
fun funA(a: (Int) -> Int): Int {
    a.apply { }
    return a.invoke(2)
}

// SAM转换：在kotlin和Java8中表示的是仅有一个抽象方法的接口，使用Lambda表达式来简写接口类的参数'
// SAM明确的名称叫做函数式接口

// 带接收者的函数类型


class User {
    var userName: String = ""
    var webSite: String = ""
}

//fun User.apply(block: (User) -> Unit): User {
//    block(this)
//    return this
//}

// 带接收者的参数类型
fun User.apply(block: User.() -> Unit): User {
    block()
    return this
}

// 下属方法于上述apply方法等价
fun apply(user: User, block: (User) -> Unit) {
    block(user)
}


fun userApply() {
    val mUser = User()
//    mUser.apply {
//        it.userName
//        it.webSite
//    }

    mUser.apply {
        userName
        webSite
    }
}




