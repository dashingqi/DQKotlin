package com.dashingqi.dqkotlin.main

import kotlin.system.exitProcess

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/22 11:56
 */
 fun main() {
    while (true) {

        val input = readLine() ?: continue

        if (input == "exit") exitProcess(0)

        val inputList = input.split(" ")
        val result = calculate(inputList)
        if (result == null) {
            println("输入的格式不对")
            continue
        } else {
            println("result == $result")
        }
    }

}

private fun calculate(inputList: List<String>): Int? {
    if (inputList.size != 3) return null
    val left = inputList[0].toInt()
    val right = inputList[2].toInt()
    return when (Operation.valueOf(inputList[1])) {
        Operation.ADD -> left + right
        Operation.MINUS -> left - right
        Operation.MULIT -> left * right
        Operation.DIVI -> left / right
    }
}

enum class Operation(val value: String) {
    ADD("+"),
    MINUS("-"),
    MULIT("*"),
    DIVI("/")
}