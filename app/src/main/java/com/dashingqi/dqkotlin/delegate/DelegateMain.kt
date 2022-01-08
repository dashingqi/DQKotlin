package com.dashingqi.dqkotlin.delegate

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/8 16:03
 */

fun main() {
    val sqldb = SQLDB()
    UniversalDB(sqldb).save()

    val text: String by lazy {
        ""
    }

}