package com.dashingqi.widget.flipper

import android.content.Context
import android.widget.RemoteViews
import com.dashingqi.widget.R
import com.dashingqi.widget.factory.DefaultRemoteViewsFactory

class ViewFlipperRemoteViewsFactory(private val context: Context) : DefaultRemoteViewsFactory() {
    private val frameList =
        listOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
            R.drawable.img_14,
            R.drawable.img_15
        )

    override fun getCount(): Int = frameList.size

    override fun getViewAt(position: Int): RemoteViews =
        RemoteViews(context.packageName, R.layout.item_view_flipper_img).apply {
            this.setImageViewResource(R.id.vfImg, frameList[position])
        }


}