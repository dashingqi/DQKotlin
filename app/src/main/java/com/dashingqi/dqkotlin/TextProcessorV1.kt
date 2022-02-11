package com.dashingqi.dqkotlin

import android.annotation.SuppressLint

/**
 * @author zhangqi61
 * @since 2022/2/11
 */
class TextProcessorV1 {

    fun processText(text: String): List<WordFreq> {
        return text.clean()
            .split(" ")
            .getWordsCount()
            .mapToList { WordFreq(it.key, it.value) }
            .sortedByDescending { it.frequency }
    }

    /**
     * 清洗文本
     * @param text String 清洗前的文本
     * @return String 清洗后的文本
     */
    private fun String.clean(): String {
        return this.replace("[^A-Za-z]".toRegex(), " ")
    }

    @SuppressLint("NewApi")
    private fun List<String>.getWordsCount(): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        for (word in this) {
            if (word == "") continue
            val trim = word.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count + 1
        }
        return map
    }

    // inline关键字减少了一次函数的调用
    // 少创建了一个匿名内部类对象
    inline fun <T> Map<String, Int>.mapToList(transform: (Map.Entry<String, Int>) -> T): MutableList<T> {
        val list = mutableListOf<T>()
        for (entry in this) {
            val freq = transform.invoke(entry)
            list.add(freq)
        }
        return list
    }

    @JvmName("mapToList(StringToString)")
    inline fun <T> Map<String, String>.mapToList(transform: (Map.Entry<String, String>) -> T): MutableList<T> {
        val list = mutableListOf<T>()
        for (entry in this) {
            val freq = transform.invoke(entry)
            list.add(freq)
        }
        return list
    }
}

