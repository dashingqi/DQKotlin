package com.dashingqi.dqkotlin.delegate

/**
 * @desc : 属性的委托
 * @author : zhangqi
 * @time : 2022/2/14 23:05
 */
class Item {
    var count: Int = 0

    // 我们把total属性的getter和setter都委托给了count
    // 其中 "::count"代表count属性的引用
    var total: Int by ::count
}