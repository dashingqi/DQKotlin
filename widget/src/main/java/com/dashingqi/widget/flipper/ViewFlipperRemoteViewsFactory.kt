package com.dashingqi.widget.flipper

import android.content.Context
import android.widget.RemoteViews
import com.dashingqi.widget.R
import com.dashingqi.widget.factory.DefaultRemoteViewsFactory

class ViewFlipperRemoteViewsFactory(private val context: Context) : DefaultRemoteViewsFactory() {
    private val frameList = listOf(
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

    private val labelList = listOf(
        "时光匆匆，岁月流逝。",
        "心怀感恩，珍惜当下。",
        "梦想前行，勇往直前。",
        "快乐如影，伴随左右。",
        "幸福满怀，笑对人生。",
        "真诚相待，情意相投。",
        "拥抱阳光，追逐希望。",
        "云淡风轻，心安如愿。",
        "闲看花开，静待时光。",
        "爱在心间，永不磨灭。",
        "拾起希望，走向明天。",
        "心有所向，必将成功。",
        "坚持不懈，梦想成真。",
        "善待他人，温暖自己。",
        "披荆斩棘，勇往直前。"
    )

    override fun getCount(): Int = frameList.size

    override fun getViewAt(position: Int): RemoteViews =
        RemoteViews(context.packageName, R.layout.item_view_flipper_img).apply {
            this.setImageViewResource(R.id.vfImg, frameList[position])
        }


}