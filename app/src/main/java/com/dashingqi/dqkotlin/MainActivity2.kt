package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.iterators.model.Student
import kotlinx.coroutines.CoroutineScope

val class1 = listOf<Student>(
    Student("小明", 83),
    Student("小红", 92),
    Student("小李", 50),
    Student("小白", 67),
    Student("小琳", 72),
    Student("小刚", 97),
    Student("小强", 57),
    Student("小林", 86)
)

val class2 = listOf<Student>(
    Student("大明", 80),
    Student("大红", 97),
    Student("大李", 53),
    Student("大白", 64),
    Student("大琳", 76),
    Student("大刚", 92),
    Student("大强", 58),
    Student("大林", 88)
)

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        filterOperate()
        mapOperate()
        flattenOperate()
        groupByOperate()
        takeOperate()
        dropStudent()
        sliceStudent()
        sumScore()
        joinSource()
    }
    // ==============================================过滤操作符================================================
    /**
     * 过滤操作符使用
     */
    private fun filterOperate() {

        // filter的使用
        val result = class1.filter { it.score < 60 }
        Log.d(TAG, " result 【filter】 is $result")
        val indexList = mutableListOf<Int>()

        // filterIndexed 的使用
        class1.filterIndexed { index, student ->
            val condition = student.score < 60
            if (condition) {
                indexList.add(index)
            }
            condition
        }
        Log.d(TAG, "indexList is $indexList")
    }

    // ============================================转换操作符===============================================
    /**
     * 转换操作符
     */
    private fun mapOperate() {

        val result = class1.map {
            it.copy(name = "小某某")
        }
        Log.d(TAG, "result 【map】 is $result")
    }

    /**
     * flatten 操作符的使用
     * 作用：是将嵌套的集合【展开】【平铺】成一个非嵌套的集合
     * 内部使用了addAll()方法
     */
    private fun flattenOperate() {
        val list = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        val result = list.flatten()
        Log.d(TAG, "list 【flatten】is $list")
        Log.d(TAG, "result 【flatten】 is $result")
    }
    // ===========================================分组操作符============================================
    /**
     * 分组操作符
     * 【以什么标准进行分组】
     */
    private fun groupByOperate() {
        val result = class1.groupBy { "${it.score / 10}0分组" }
        Log.d(TAG, "result 【groupBy】is $result")
    }


    // ==========================================分割操作符=============================================
    /**
     *
     * take 操作符
     */
    private fun takeOperate() {
        val first3 = class1
            .sortedByDescending { it.score }
            .take(3)
        Log.d(TAG, "first3 【take】 is $first3")

        val last3 = class1
            .sortedByDescending { it.score }
            .takeLast(3)
        Log.d(TAG, "last3 【takeLast】is $last3")
    }

    /**
     * drop 操作符
     * 剔除的作用
     */
    private fun dropStudent() {
        val middle = class1
            .sortedByDescending { it.score }
            .drop(3)
            .dropLast(3)

        Log.d(TAG, "middle 【drop】is $middle")
    }

    /**
     * slice 操作符
     */
    private fun sliceStudent() {
        val first3 = class1
            .sortedByDescending { it.score }
            .slice(0..2)

        val size = class1.size

        val last3 = class1
            .sortedByDescending { it.score }
            .slice(size - 3 until size)

        Log.d(
            TAG, """
            first3 【slice】 is $first3
            last3  【slice】 is $last3
        """.trimIndent()
        )

    }

    // ===========================================求和操作符============================================
    /**
     * sumOf
     * reduce
     * fold
     * 操作符
     */
    private fun sumScore() {
        val sum1 = class1.sumOf { it.score }
        val sum2 = class1
            .map { it.score }
            .reduce { acc, score ->
                Log.d(
                    TAG, """
                    acc is $acc
                    score is $score
                """.trimIndent()
                )
                acc + score
            }

        val sum3 = class1
            .map { it.score }
            // 这里传0 代表赋值了一个初始值
            .fold(0) { acc, score ->
                Log.d(
                    TAG, """
                    acc is $acc
                    score is $score
                """.trimIndent()
                )
                acc + score
            }

        Log.d(
            TAG, """
            sum1 is $sum1
            sum2 is $sum2
            sum3 is $sum3
        """.trimIndent()
        )
    }

    private fun joinSource() {
        val reduceResult = class1
            .map { it.score.toString() }
            .reduce { acc, s ->
                acc + s
            }

        val foldResult = class1
            .map { it.score.toString() }
            .fold("Prefix=") { acc, s ->
                acc + s
            }

        Log.d(
            TAG, """
            reduceResult is $reduceResult
            foldResult is $foldResult
        """.trimIndent()
        );
    }


    // ===========================================函数引用==============================================
    fun fun1(num: Int): Double {
        return num.toDouble()
    }

    // 函数引用
    val f1: (Int) -> Double = ::fun1

    fun CoroutineScope.fun2(num: Int): Double {
        return num.toDouble()
    }

    // val f2: CoroutineScope.(Int) -> Double = CoroutineScope::fun2

    suspend fun fun3(num: Int): Double {
        return num.toDouble()
    }

    val f3: suspend (Int) -> Double = ::fun3

    companion object {
        private const val TAG = "MainActivity2"
    }
}