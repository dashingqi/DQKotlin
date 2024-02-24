package com.dashingqi.widget.flipper

import android.content.Intent
import android.widget.RemoteViewsService

class ViewFlipperAdapterService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?) =
        ViewFlipperRemoteViewsFactory(this.applicationContext)
}