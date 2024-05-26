package com.dashingqi.dqkotlin

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager

class DqAnimationsActivity : AppCompatActivity() {
    private var isExpanded1 = false
    private var isExpanded2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dq_animations)

        val rootLayout = findViewById<FrameLayout>(R.id.rootContainer)
        val subContainer1 = findViewById<FrameLayout>(R.id.subContainer1)
        val subContainer2 = findViewById<FrameLayout>(R.id.subContainer2)
        val subContainer3 = findViewById<FrameLayout>(R.id.subContainer3)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        subContainer2.visibility = View.GONE
        subContainer3.visibility = View.GONE

        // First animation for subContainer1
        Handler().postDelayed({
            subContainer1.visibility = View.VISIBLE
            val transition1 = ChangeBounds()
            transition1.duration = 300
            TransitionManager.beginDelayedTransition(rootLayout, transition1)

            val params = rootLayout.layoutParams
            params.width = 400
            params.height = 400
            rootLayout.layoutParams = params
            isExpanded1 = true
        }, 500)

        // Pause for 2 seconds
        Handler().postDelayed({
            val transition2 = ChangeBounds()
            transition2.duration = 300
            TransitionManager.beginDelayedTransition(rootLayout, transition2)

            val params = rootLayout.layoutParams
            params.width = 600
            params.height = 600
            rootLayout.layoutParams = params
            isExpanded1 = false
        }, 2500)

        // Pause for 4 seconds
        Handler().postDelayed({
            subContainer2.visibility = View.VISIBLE
            val transition3 = ChangeBounds()
            transition3.duration = 300
            TransitionManager.beginDelayedTransition(rootLayout, transition3)

            val params = rootLayout.layoutParams
            params.width = 800
            params.height = 800
            rootLayout.layoutParams = params
            isExpanded2 = true
        }, 7000)

        // SubContainer3 animation
        Handler().postDelayed({
            subContainer3.visibility = View.VISIBLE
            val transition4 = ChangeBounds()
            transition4.duration = 300
            TransitionManager.beginDelayedTransition(rootLayout, transition4)

            val params = rootLayout.layoutParams
            params.width = 800
            params.height = 600
            rootLayout.layoutParams = params

            // Button2 move and expand to Button3's position with a path
            val path = Path().apply {
                moveTo(button2.x, button2.y)
                lineTo(button3.x, button3.y)
            }

            val animator = ObjectAnimator.ofFloat(button2, View.X, View.Y, path).apply {
                duration = 300
            }
            animator.start()
        }, 12000)
    }
}