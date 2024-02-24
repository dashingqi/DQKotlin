package com.dashingqi.widget.pin

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.os.Build

/**
 * @desc : Widget request pin
 * @author : zhangqi
 * @time : 2024/2/24 20:34
 */
fun ComponentName.requestPin(context: Context) {
    // 8.0以上支持的功能
    val widgetManager = AppWidgetManager.getInstance(context) ?: return
    val isO = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    if (!isO) return
    val isSupport = widgetManager.isRequestPinAppWidgetSupported
    if (!isSupport) return
    // 发起Widget添加请求
    widgetManager.requestPinAppWidget(this, null, null)
}