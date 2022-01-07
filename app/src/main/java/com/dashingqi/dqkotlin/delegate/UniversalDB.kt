package com.dashingqi.dqkotlin.delegate

/**
 * @author zhangqi61
 * @since 2022/1/7
 */

// 通过by关键字 将接口实现委托给 db
class UniversalDB(db: DB) : DB by db