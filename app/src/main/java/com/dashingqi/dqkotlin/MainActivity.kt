package com.dashingqi.dqkotlin

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater.Factory2
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColorInt
import androidx.core.view.LayoutInflaterCompat
import androidx.databinding.DataBindingUtil
import com.dashingqi.coroutine.exception.coroutineException
import com.dashingqi.coroutine.current.*
import com.dashingqi.coroutine.exception.structMain
import com.dashingqi.coroutine.exception.supervisorJobMethod
import com.dashingqi.dqkotlin.databinding.ActivityMainBinding
import com.dashingqi.http.HttpV2
import com.dashingqi.objects.A
import com.dashingqi.objects.B
import com.dashingqi.objects.Main
import com.dashingqi.objects.PersonManager

import com.dashingqi.service.ApiService
import com.dashingqi.trys.tryMain
import com.hjq.xtoast.XToast
import kotlinx.coroutines.runBlocking
import org.w3c.dom.Text
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        handleDslView(binding.rootView)
        mapOperate()

//        val runnable = Runnable {
//            XToast<XToast<*>>(this)
//                .apply {
//                    setContentView(R.layout.layout_toast_hint)
//                    setText(R.id.message, "点我消失")
//                    setDuration(1000)
//                    setOnClickListener(
//                        R.id.message,
//                        XToast.OnClickListener<TextView?> { toast: XToast<*>, view: TextView? ->
//                            toast.cancel()
//
//                        })
//
//                }
//                .show()
//        }
//        findViewById<TextView>(R.id.hl).postDelayed(runnable, 6000)
//        thread {
//            Runnable {
//                Log.d(TAG, "current thread is ${Thread.currentThread().name} ")
//
//                val wanAndroidService = HttpV2.create<ApiService>()
//                val wxArticle = wanAndroidService.repos(lang = "kotlin", since = "weekly")
//                Log.d(TAG, "wxArticle data is ${wxArticle?.msg}")
//            }.run()
//        }

        runBlocking {
//            onFlowLifecycle()
//            onFlowCatch()
//            selectMethod()
            //selectChannelMethod()
//            selectChannelMethod()
//            cancelAllDeferred()
//            coroutineCurrent()
            //coroutineCurrentJobs()
//            coroutineMutexMain()
//            actorMain()
//            noShareState()
//            noShareStateMethod()
        }

        val result = kotlin.runCatching {
            val i = 3
            6
        }
        result.onFailure {
            Log.d(TAG, "onFailure perform  exception is $it")
        }
        result.onSuccess {
            Log.d(TAG, "onSuccess perform result is $it")
        }
        findViewById<TextView>(R.id.hl).setOnClickListener {
            AlertDialog
                .Builder(this)
                .setTitle("测试测试")
                .setMessage("这是一个严肃的测试")
                .setCancelable(false)
                .setPositiveButton("弹出Toast") { dialog, which ->

                }
                .setNegativeButton("弹出Toast") { dialog, which ->
                    XToast<XToast<*>>(this)
                        .apply {
                            setContentView(R.layout.layout_toast_hint)
                            setText(R.id.message, "点我消失")
                            setDuration(1000)
                            setOnClickListener(
                                R.id.message,
                                XToast.OnClickListener<TextView?> { toast: XToast<*>, view: TextView? ->
                                    toast.cancel()

                                })

                        }
                        .show()
                }
                .show()
        }

        coroutineException()

        supervisorJobMethod()

        val personManager = PersonManager.getInstance("Qi")
        personManager.managePerson()
        tryMain()

    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private fun recordViewTime() {
        LayoutInflaterCompat.setFactory2(layoutInflater, object : Factory2 {
            override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
                return null
            }

            override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
                return null
            }

        })
    }

    private fun handleDslView(rootView: LinearLayout) {
        createRootView {
            dslVLinearLayout {
                dslTextView {
                    text = "TextView"
                }
                dslTextView {
                    text = "TextView1"
                }
                dslHLinearLayout {
                    dslTextView {
                        text = "TextView3"
                    }
                    dslTextView {
                        text = "TextView4"
                    }
                }

                dslButton {
                    setOnClickListener {

                    }
                }
            }
        }
    }
}

inline fun ViewGroup.dslTextView(action: TextView.() -> Unit) {
    this.addView(TextView(this.context).apply(action))
}

inline fun ViewGroup.dslButton(action: Button.() -> Unit) {
    this.addView(Button(this.context).apply(action))
}

inline fun ViewGroup.dslEditText(action:EditText.()->Unit){

}

inline fun ViewGroup.dslAppCompatButton(action: AppCompatButton.() -> Unit) {
    this.addView(AppCompatButton(this.context).apply(action))
}

inline fun ViewGroup.dslAppCompatTextView(action: AppCompatTextView.() -> Unit) {
    this.addView(AppCompatTextView(this.context).apply(action))
}


inline fun ViewGroup.dslHLinearLayout(action: LinearLayout.() -> Unit) {
    this.addView(LinearLayout(this.context).apply {
        orientation = LinearLayout.HORIZONTAL
        action()
    })
}

inline fun ViewGroup.dslVLinearLayout(action: LinearLayout.() -> Unit) {
    this.addView(LinearLayout(this.context).apply {
        orientation = LinearLayout.VERTICAL
        action()
    })
}

inline fun Activity.createRootView(rootView: ViewGroup.() -> Unit) {
    this.setContentView(FrameLayout(this).apply(rootView))
}

