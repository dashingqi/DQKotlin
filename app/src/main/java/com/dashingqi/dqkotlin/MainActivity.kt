package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {
        findViewById<TextView>(R.id.tv)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = User("Dashingqi", 12)
        user.apply {

        }
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })

        textView.setOnClickListener(View.OnClickListener { view: View ->

        })

        textView.setOnClickListener({ view: View ->

        })

        textView.setOnClickListener({ view ->

        })

        textView.setOnClickListener({ it ->

        })

        textView.setOnClickListener({

        })

        textView.setOnClickListener() {

        }

        textView.setOnClickListener {

        }
    }

    /**
     * 自定义的apply
     * @receiver User 带接受者的函数类型
     * @param block [@kotlin.ExtensionFunctionType] Function1<User, Unit>
     * @return User
     */
    fun User.apply(block: User.() -> Unit): User {
        block()
        return this
    }


    fun User.apply2(block: (user: User) -> Unit): User {
        block(this)
        return this
    }

    fun fun1(action: () -> Unit) {

    }

    inline fun lambdaFun(noinline action: () -> Unit, action1: () -> Unit) {
        lambdaFun1(action)
    }

    fun lambdaFun1(action: () -> Unit) {

    }

    inline fun lambdaFun2(noinline action: () -> Unit, crossinline action1: () -> Unit): () -> Unit {
        action.invoke()
        return action
    }



}