package com.dashingqi.data

/**
 * @desc : 定义数据类
 * @author : zhangqi
 * @time : 2022/2/25 23:09
 */
data class Repo(
    var added_stars: String?,
    var avatars: List<String>?,
    var desc: String?,
    var forks: String?,
    var lang: String?,
    var repo: String?,
    var repo_link: String?,
    var stars: String?
)

data class RepoList(
    var count: Int?,
    var items: List<Repo>?,
    var msg: String?
)
