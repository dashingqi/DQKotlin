package com.dashingqi.dqkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val textView by lazy {
        findViewById<TextView>(R.id.tv)
    }
    val action1: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = User("Dashingqi", 12)
        user.apply {

        }

        fun1 {
            Log.d(TAG, ": ")
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

        // lambda 表达式演变 匿名内部类
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }

        })

        // object关键字可以省略掉,不再是匿名内部类，而是lambda表达式
        textView.setOnClickListener(View.OnClickListener { view: View ->
        })

        // View.OnClickListener 是SAM 构造器，lambda表达式是不需要它的
        textView.setOnClickListener({ view: View ->
        })

        // kotlin是具有类型推导的
        textView.setOnClickListener({ view ->

        })

        // lambda表达式只有一的参数时，可以使用it
        textView.setOnClickListener({ it ->

        })

        // lambda表达式是中it可以被省略

        textView.setOnClickListener({})

        // lambda表达式作为函数最后一个参数时是可以放到括号外面的

        textView.setOnClickListener() {

        }

        // 当函数参数只有一个lambda表达式是，括号是可以省略的
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

    inline fun fun1(action: () -> Unit) {
        Log.d(TAG, ": nihao1")
        action.invoke()

    }

    // 当声明一个高阶函数，参数是函数类型，同时返回值也是函数类型
    // 该函数类型还被用作其他高阶函数的参数，此时就需要使用noinline
    //
    inline fun lambdaFun(noinline action: () -> Unit, action1: () -> Unit): () -> Unit {
        lambdaFun1(action)
        return action
    }

    fun lambdaFun1(action: () -> Unit) {

    }

    inline fun lambdaFun2(noinline action: () -> Unit, crossinline action1: () -> Unit): () -> Unit {
        action.invoke()
        return action
    }

    // ====================return难题===============================
   inline fun returnFun( crossinline action: () -> Unit){
        fun2 {
            Log.d(TAG, "returnFun")
            // 如果fun2定义成正常的高阶函数，直接使用return是编译不通过的
            // 如果想使用return 关键字可以将fun2定义成内联的高阶函数
            action()
        }
    }

     fun fun2(action: () -> Unit) {
        Log.d(TAG, "调用前")
        action.invoke()
        Log.d(TAG, "调用后")
    }

    // crossinline的作用是当有被这个修饰的参数会告诉IED来检查 该lambda表达式中是否有return语句



}