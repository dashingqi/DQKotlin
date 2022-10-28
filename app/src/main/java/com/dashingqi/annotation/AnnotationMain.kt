package com.dashingqi.annotation

/**
 * @author zhangqi61
 * @since 2022/10/26
 */

@Target(AnnotationTarget.CLASS)
@MustBeDocumented
public annotation class Deprecated(
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith(""),
    val level: DeprecationLevel = DeprecationLevel.WARNING
)