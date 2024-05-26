package com.dashingqi.widget.stack

import android.content.Context
import android.widget.RemoteViews
import com.dashingqi.widget.R
import com.dashingqi.widget.factory.DefaultRemoteViewsFactory

class StackRemoteViewsFactory(private val context: Context) : DefaultRemoteViewsFactory() {
    private val mItem by lazy {
        listOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
        )
    }

    override fun getCount(): Int = mItem.size

    override fun getViewAt(position: Int): RemoteViews {
        return RemoteViews(context.packageName, R.layout.item_view_flipper_img).apply {
            this.setImageViewResource(R.id.vfImg, mItem[position])
        }
    }
}