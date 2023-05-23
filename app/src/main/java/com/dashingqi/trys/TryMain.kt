package com.dashingqi.trys

import android.util.Log

/**
 * @author zhangqi61
 * @since 2023/5/22
 */

private const val TAG = "TryMain"
fun tryMain(): Int {
    try {
        Log.d(TAG, "try perform")
        for (i in 0..5) {
            if (i != 3) {
                continue
            }
        }
        Log.d(TAG, "try perform continue after ")
        return 4
    } catch (_: Exception) {

    } finally {
        Log.d(TAG, "finally perform ")
    }

    return 0
}