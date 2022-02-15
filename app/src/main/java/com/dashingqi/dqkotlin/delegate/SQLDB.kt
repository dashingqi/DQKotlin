package com.dashingqi.dqkotlin.delegate

import android.util.Log

/**
 * @author zhangqi61
 * @since 2022/1/7
 */
class SQLDB : DB {
    private  val TAG = "SQLDB"
    override fun save() {
        Log.d(TAG, "save: ")
    }
}