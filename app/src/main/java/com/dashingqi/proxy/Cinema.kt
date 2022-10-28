package com.dashingqi.proxy

/**
 * @author zhangqi61
 * @since 2022/10/27
 */
class Cinema(var movie: Movie) : Movie {
    override fun play() {
        playBefore()
        movie.play()
        playAfter()
    }

    private fun playBefore() {

    }

    private fun playAfter() {

    }
}