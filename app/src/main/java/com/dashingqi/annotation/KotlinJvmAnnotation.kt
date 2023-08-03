package com.dashingqi.annotation

/**
 * @author zhangqi61
 * @since 2023/8/3
 */
object KotlinJvmAnnotation {
    fun getMethod(){

    }
}

class KotlinJvmAnnotationOne{
    var name = "dashingqi"

    val thisName by lazy {
        ""
    }

    companion object {
        fun getMethod(){

        }
    }
}

fun getStaticMethod() {
    val kotlinJvmAnnotationOne = KotlinJvmAnnotationOne()
    kotlinJvmAnnotationOne.name = ""

}