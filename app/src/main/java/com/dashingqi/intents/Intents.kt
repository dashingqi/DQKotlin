package com.dashingqi.intents

import android.content.Intent
import android.net.Uri

/**
 * @desc : Intent的测试类
 * @author : zhangqi
 * @time : 2023/4/1 16:30
 */


/**
 * intent://main#Intent;scheme=dashing;category=android.intent.category.DEFAULT;category=android.intent.category.BROWSABLE;end
 * @return String
 */
fun getIntentUri(): String {
    return Intent().apply {
        action = Intent.ACTION_VIEW
        addCategory(Intent.CATEGORY_BROWSABLE)
        addCategory(Intent.CATEGORY_DEFAULT)
        data = Uri.parse("dashing://main?k=dashing&v=qi")
    }.toUri(Intent.URI_INTENT_SCHEME)
}