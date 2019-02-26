package com.example.administrator.androidtoh5.module.webStudy

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.administrator.androidtoh5.R
import com.example.administrator.androidtoh5.util.L
import kotlinx.android.synthetic.main.activity_java_to_js.*
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.toast

/**
 * Created by 舍长
 * describe:该Activity实现了Android传递用户名数据给网页显示，网页点击按钮调用Androdi的吐司提示
 */
class JavaToJsActivity : AppCompatActivity() {

    /**
     * 声明WebView
     */
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_to_js)
        //进行WebView的基础配置
        initView()
        //当点击按钮时，触发登陆方法，跳转到网页页面
        mBtnNext.setOnClickListener {
            L.d("按钮的点击事件")
            login()//登录方法
        }
    }

    /**
     *  登录方法
     */
    private fun login() {
        //获取输入框的用户名
        val userName: String = mEditView.text.toString().trim()

        if (!TextUtils.isEmpty(userName)) {
            //调用网页的js代码，调用网页javaToJs方法，将用户名作为参数传入该方法，后面该方法就会显示到网页上
            webView?.loadUrl("javascript:javaToJs('$userName')")
            //将webView显示到界面上
            setContentView(webView)
        }
    }

    /**
     * 进行WebView的配置
     */
    @SuppressLint("AddJavascriptInterface", "SetJavaScriptEnabled")
    private fun initView() {
        //声明WebView对象
        webView = WebView(this)
        //该类可以对WebView进行配置
        val webSettings: WebSettings = webView?.settings!!
        //让WebView支持javaScript脚步语言
        webSettings.javaScriptEnabled = true
        /**
         * 让WebView支持javaScript代码调用java代码
         * JsToJava是待会点击网页上的按钮后，webView会回调该方法，Android与H5要交互的代码要写在里面
         */
        webView?.addJavascriptInterface(JsToJava(), "Android")
        //加载网络url地址
        webView?.loadUrl("https://a704.gitee.io/web/JavaToJs.html")
    }


    /**
     *该方法是为了让网页调用，从而实现点击网页代码，弹出吐司
     */
    internal inner class JsToJava {
        //必须有该注解
        @JavascriptInterface
        fun show() {
            toast("我被js调用了啦")
        }

    }
}
