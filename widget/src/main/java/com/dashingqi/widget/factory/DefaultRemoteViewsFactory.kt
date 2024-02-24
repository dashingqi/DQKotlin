package com.dashingqi.widget.factory

import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory

/**
 * 默认的 RemoteViewsFactory
 */
open class DefaultRemoteViewsFactory : RemoteViewsFactory {
    override fun onCreate() {}

    override fun onDataSetChanged() {}

    override fun onDestroy() {}

    override fun getCount(): Int = 0

    override fun getViewAt(position: Int): RemoteViews? = null

    override fun getLoadingView(): RemoteViews? = null
    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = position.toLong()

    override fun hasStableIds(): Boolean = true
}