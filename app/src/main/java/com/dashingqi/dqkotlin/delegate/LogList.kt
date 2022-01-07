package com.dashingqi.dqkotlin.delegate

/**
 * @author zhangqi61
 * @since 2022/1/7
 */
class LogList(private val list: MutableList<String>, val log: () -> Unit) : MutableList<String> by list {
    fun getAndLog(index: Int): String {
        log()
        return get(index)
    }
}