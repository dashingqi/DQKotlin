package com.dashingqi.service

import com.dashingqi.annotation.Field
import com.dashingqi.annotation.GET
import com.dashingqi.data.RepoList

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/2/25 23:20
 */
interface ApiService {


    @GET("/repo")
    fun repos(
        @Field("lang") lang: String,
        @Field("since") since: String
    ): RepoList?

}