package com.dashingqi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dashingqi.dqkotlin.R
import com.dashingqi.process.test.OtherProcessService

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        startService(Intent(this, OtherProcessService::class.java))
    }
}