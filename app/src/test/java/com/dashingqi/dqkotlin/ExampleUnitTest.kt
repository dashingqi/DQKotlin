package com.dashingqi.dqkotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        val text = "Android Studio provides the fastest tools for building apps on every type of Android"
        val processText = TextProcessorV1().processText(text)
        assertEquals(2, processText[0].frequency)
        assertEquals("Android", processText[0].world)
    }
}