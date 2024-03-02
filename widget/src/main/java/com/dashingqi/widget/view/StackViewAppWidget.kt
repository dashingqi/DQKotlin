package com.dashingqi.widget.view

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.dashingqi.widget.R
import com.dashingqi.widget.flipper.ViewFlipperAdapterService
import com.dashingqi.widget.stack.StackWidgetService

/**
 * ViewFlipper 实现的 Widget
 */
class StackViewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        context ?: return
        appWidgetIds ?: return
        appWidgetManager ?: return
        appWidgetIds.forEach { appWidgetId ->
            val remoteViews = RemoteViews(context.packageName, R.layout.stack_view_layout)
            val intent = Intent(context, StackWidgetService::class.java)
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            remoteViews.setRemoteAdapter(R.id.stack_view, intent)
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)

        }
    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
    }
}