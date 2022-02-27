package com.dashingqi.http

import com.dashingqi.annotation.Field
import com.dashingqi.annotation.GET
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/2/25 23:21
 */

object HttpV1 {
    /** base url */
    var baseUrl = "https://baseurl.com"

    /** OkHttp */
    private val okHttpClient = OkHttpClient()

    /** 使用Gson解析JSON*/
    private val gson = Gson()

    /**
     *
     * @param service Class<T>
     * @return T
     */
    fun <T> create(service: Class<T>): T {

        return Proxy.newProxyInstance(
            service.classLoader,
            arrayOf<Class<*>>(service)
        ) { proxy, method, args ->

            val annotations = method.annotations

            for (annotation in annotations) {
                if (annotation is GET) {
                    val url = baseUrl + annotation.value
                    return@newProxyInstance invoke(url, method, args)
                }
            }
            return@newProxyInstance null

        } as T
    }

    private fun invoke(path: String, method: Method, args: Array<Any>): Any? {
        if (method.parameterAnnotations.size != args.size) return null
        // 根据url拼接参数
        var url = path
        // 取出方法中参数修饰的注解
        val parameterAnnotations = method.parameterAnnotations
        for (index in parameterAnnotations.indices) {
            for (parameterAnnotation in parameterAnnotations[index]) {
                // 筛选出@Filed的注解
                if (parameterAnnotation is Field) {

                    // 获取到注解中的value 当作key
                    val key = parameterAnnotation.value
                    // 取出方法中参数对应的值
                    val value = args[index].toString()
                    url += if (!url.contains("?")) {
                        "?$key=$value"
                    } else {
                        "$key=$value"
                    }
                }
            }
        }
        // 使用okHttpClient进行网络请求
        val request = Request.Builder()
            .url(url)
            .build()
        val response = okHttpClient.newCall(request).execute()

        // 使用gson进行JSON解析
        val genericReturnType = method.genericReturnType
        val body = response.body
        val string = body?.string()
        val result = gson.fromJson<Any?>(string, genericReturnType)
        // 返回结果
        return result

    }
}