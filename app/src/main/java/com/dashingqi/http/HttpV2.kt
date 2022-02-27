package com.dashingqi.http

import android.util.Log
import com.dashingqi.annotation.Field
import com.dashingqi.annotation.GET
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @desc : Http version 2
 * @author : zhangqi
 * @time : 2022/2/26 10:26
 */
object HttpV2 {

    /** OkHttpClient */
    private val okHttpClient by lazy {
        OkHttpClient()
    }

    /** Gson */
    private val gson by lazy {
        Gson()
    }

    /** base url */
    var baseUrl = "https://trendings.herokuapp.com"

    /**
     * create
     * 采用了【类型实化】技术
     * @return T
     */
    inline fun <reified T> create(): T {
        return Proxy.newProxyInstance(
            T::class.java.classLoader,
            arrayOf(T::class.java)
        ) { _, method, args ->
            return@newProxyInstance method.annotations
                .filterIsInstance<GET>()
                .takeIf { it.size == 1 }
                ?.let { invoke("$baseUrl${it[0].value}", method, args) }

        } as T
    }

    fun invoke(url: String, method: Method, args: Array<Any>): Any? =
        // 获取方法中所有参数的注解
        method.parameterAnnotations
            .takeIf { it.size == args.size }
            ?.mapIndexed { index, it -> Pair(it, args[index]) }
            // fold操作符就是高阶函数的for循环
            ?.fold(url, ::parseUrl)
            ?.let { Request.Builder().url(it).build() }
            ?.let {
                val json = okHttpClient.newCall(it).execute().body?.string()
                Log.d("MainActivity", "json is $json");
                json
            }
            ?.let { gson.fromJson(it, method.genericReturnType) }


    /**
     * 拼接url
     * @param acc String
     * @param pair Pair<Array<Annotation>, Any>
     * @return String
     */
    private fun parseUrl(acc: String, pair: Pair<Array<Annotation>, Any>) =
        pair.first.filterIsInstance<Field>()
            .first()
            .let { field ->
                if (acc.contains("?")) {
                    "$acc${field.value}=${pair.second}"
                } else {
                    "$acc?${field.value}=${pair.second}"
                }
            }
}