package com.dashingqi.service

import com.dashingqi.annotation.Field
import com.dashingqi.annotation.GET

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/2/27 12:18
 */
interface WanAndroidService {

    /**
     * 获取公众号列表
     * @return String
     */
    @GET("/article/list/0/json")
    fun getWxArticle(@Field("author") kValue: String): String
}