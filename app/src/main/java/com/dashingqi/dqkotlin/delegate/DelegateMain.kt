package com.dashingqi.dqkotlin.delegate

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/8 16:03
 */


val text: String by lazy {
    ""
}
//val test1: String
//    get() = {
//        lazy {
//            ""
//        }
//    }

fun main() {
    val sqldb = SQLDB()
    UniversalDB(sqldb).save()


}