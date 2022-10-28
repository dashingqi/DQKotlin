package com.dashingqi.proxy

/**
 * @author zhangqi61
 * @since 2022/10/27
 */
class RealMovie : Movie {
    override fun play() {
        println("正在播放《绝命毒师》")
    }
}