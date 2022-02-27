package com.dashingqi.annotation

/**
 * @desc : 定义网络请求的注解
 * @author : zhangqi
 * @time : 2022/2/25 23:11
 */


/**
 * 用于标注get请求，修饰在函数上
 * @property value String
 * @constructor
 */
@Target(AnnotationTarget.FUNCTION)
// 注解是运行时访问
@Retention(AnnotationRetention.RUNTIME)
annotation class GET(val value: String)

/**
 * 用于标注函数中的参数
 * @property value String
 * @constructor
 */
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Field(val value: String)
