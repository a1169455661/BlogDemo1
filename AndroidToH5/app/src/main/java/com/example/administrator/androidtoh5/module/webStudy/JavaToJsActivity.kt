package com.example.administrator.androidtoh5.module.webStudy

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.administrator.androidtoh5.R
import com.example.administrator.androidtoh5.util.L
import kotlinx.android.synthetic.main.activity_java_to_js.*
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.toast

/**
 * 1，Java调用javaScript方法
 * 2，javaScript方法调用Java方法
 */
class JavaToJsActivity : AppCompatActivity() {

    /**
     * 声明WebView
     */
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_to_js)
        //进行WebView的基础基础配置
        initView()
        //当点击按钮时，触发登陆方法，跳转到网页页面
        mBtnNext.setOnClickListener(View.OnClickListener {
            L.d("按钮的点击事件")
            login()
        })
    }

    /**
     *  登录方法
     */
    private fun login() {
        val string: String = mEditView.text.toString().trim()

        if (!TextUtils.isEmpty(string)) {
            //调用页面的js代码的javaToJs方法把参数传递进入
            webView!!.loadUrl("javascript:javaToJs('$string')")
            //将webView显示到界面上
            setContentView(webView)
        }
    }

    /**
     * 进行基础的配置
     */
    private fun initView() {
        webView= WebView(this)
        val webSettings = webView!!.getSettings()
        //设置支持javaScript脚步语言
        webSettings.javaScriptEnabled = true

        //设置支持js调用java
        //JsToJava是js回调的类，Js调用的Java方法都应该写在里面
        webView!!.addJavascriptInterface(JsToJava(), "Android")

        //加载网络资源
        webView!!.loadUrl("https://a704.gitee.io/web/JavaToJs.html")
    }



    /**
     *js可以调用该类的方法
     */
    internal inner class JsToJava {
        //必须有该注解
        @JavascriptInterface
        fun show() {
            toast("我被js调用了啦")
        }

    }
}
