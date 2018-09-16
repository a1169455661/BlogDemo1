package com.example.administrator.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.administrator.kotlin.bean.Student
import com.google.gson.Gson


import java.net.URL
import org.jetbrains.anko.uiThread
//加了这一行后我们就不需要再findViewById了
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

/**
 *  : AppCompatActivity()  表示继承于AppCompatActivity()类
 *  ，View.OnClickListener, View.OnLongClickListener 表示继承于 View.OnClickListener 点击事件, View.OnLongClickListener 长按事件接口
 */
class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      为TextView设置值,koltin的语句后面是不需要;的，但是如果你加上也不会报错的
        txt_01.text = "你好，世界"
//       设置控件的回调监听
        init()
    }

    /**
     *  设置控件的回调监听
     */
    private fun init() {
        btn_01.setOnClickListener(this)
        btn_02.setOnClickListener(this)
        btn_03.setOnClickListener(this)
        btn_01.setOnLongClickListener(this)
        btn_02.setOnLongClickListener(this)
        btn_03.setOnLongClickListener(this)
    }

    /**
     * 重写OnClickListener接口的onClick方法
     */
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_01 -> {
//              只进行网络请求
                network()
            }

            R.id.btn_02 -> {
//              进行网络请求，并且进行json数据解析
                Toast.makeText(this, "按钮2", Toast.LENGTH_LONG).show()
                gson()
            }

            R.id.btn_03 -> {
                Toast.makeText(this, "按钮3", Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * 网络请求并使用gson解析数据
     */
    private fun gson() {
//       声明要请求的网址，在kotlin中，var能声明一切类型，而后面的:String其实是可以不加的
        val string: String = "http://www.wanandroid.com/tools/mockapi/2872/student"
//       doAsync方法作用类似java在子线程中进行网络请求，doAsync()方法是由Anko框架的，如果不加程序会崩溃哦
        doAsync() {
            val fore = URL(string).readText()
            val fromJson: Student = Gson().fromJson(fore, Student::class.java)
//           回到UI线程中去更新数据，这里的${属性名}是字符串模板，作用于Java的+属性名+相同
            this.uiThread {
                txt_01.text = "学生的名字是${fromJson.name},年龄是${fromJson.age}"
            }
        }
    }

    /**
     * 网络请求
     */
    private fun network() {
//       声明要请求的网址，在kotlin中，val能声明一切类型，而后面的:String其实是可以不加的
        val string: String = "http://www.wanandroid.com/tools/mockapi/2872/student"
//        doAsync方法作用类似java在子线程中进行网络请求，doAsync()方法是由Anko框架的，如果不加程序会崩溃哦
        doAsync {
            val fore = URL(string).readText()
            Log.d("tonjies", fore)
        }

    }

    /**
     * 重写OnLongClickListener接口的onLongClick方法
     * override符号为子类继承父类后，重写父类方法的符号
     * 其不同于我们的Java的地方在于，在Java中，该符号省略后不会报错，而kotlin会
     */
    override fun onLongClick(p0: View?): Boolean {
        Toast.makeText(this, "长按事件", Toast.LENGTH_LONG).show()
        return false
    }

}
