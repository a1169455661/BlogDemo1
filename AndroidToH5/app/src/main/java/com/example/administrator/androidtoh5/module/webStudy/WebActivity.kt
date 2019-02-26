package com.example.administrator.androidtoh5.module.webStudy

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.administrator.androidtoh5.R
import com.example.administrator.androidtoh5.util.L
import com.example.administrator.androidtoh5.util.WebUtil
import kotlinx.android.synthetic.main.activity_web.*

/**
 * Created by 舍长
 * describe:介绍了webView加载网页的几个方法
 */
class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        //加载网页url地址
        mWebView.loadUrl("https://www.jianshu.com/u/8c6b4be8770b")
        //暂停webView
        //mWebView.onPause()
        //监听图片的点击事件
        mImgUp.setOnClickListener(View.OnClickListener {
            //滑动到当前网页的顶部
            top()
            //销毁webView
//            destroy()
            //恢复webView
//            mWebView.onResume()
            //读取一段Html代码
//            readHtml()
            //隐藏垂直滚动条
//            mWebView.setVerticalScrollBarEnabled(false)
        })
    }

    private fun readHtml() {
        //WebUtil，在项目的util包下，getHtml方法的作用是读取main-assets文件夹下的html文件的代码
        val json:String=WebUtil.getHtml("index.html",this)
        L.d("读取到的html代码："+json)
        mWebView.loadData(json,"text/html",null)
    }

    private fun destroy() {
        mWebView.destroy()
    }

    private fun top() {
        val pageUp: Boolean = mWebView.pageUp(true)
        L.d("滑动到底部是否成功:$pageUp")
    }

    /**
     * 重写返回回调监听
     */
    override fun onBackPressed() {
        //判断WebView是否可返回
        if (mWebView.canGoBack()) {
            //返回上一个页
            mWebView.goBack()
            return
        }
        super.onBackPressed()
    }

    fun url(){
        //当我们需要完整的浏览器的时候不使用WebView，而是直接跳转到默认浏览器
        val uri = Uri.parse("https://www.baidu.com/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
