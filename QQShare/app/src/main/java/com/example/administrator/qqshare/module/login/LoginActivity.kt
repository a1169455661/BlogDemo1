package com.example.administrator.qqshare.module.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.administrator.qqshare.MainActivity
import com.example.administrator.qqshare.R
import com.example.administrator.qqshare.base.WinActivity
import com.example.administrator.qqshare.util.L
import com.example.administrator.qqshare.util.ShareUtils
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA
//不需要在findID
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by 舍长 on 2018/5/28.
 * 舍长:QQ登录页面
 */
class LoginActivity : WinActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mQQ.setOnClickListener(View.OnClickListener {
            L.d("登录")
            //QQ图标点击事件
            UMShareAPI.get(this@LoginActivity).getPlatformInfo(this@LoginActivity, SHARE_MEDIA.QQ, authListener)
        })
    }

    /**
     * 第三方登录回调
     */
    internal var authListener: UMAuthListener = object : UMAuthListener {

        /**
         * 开始登录的回调
         * @param platform 第三方登录的平台名称
         */
        override fun onStart(platform: SHARE_MEDIA) {
            L.d("登录的第三方平台是:" + platform)
        }

        /**
         * 登录成功回调
         * @param platform
         * @param action
         * @param map
         */
        override fun onComplete(platform: SHARE_MEDIA, action: Int, map: Map<String, String>) {
        //  遍历map集合，取出QQ登录后回调给我们的信息
            for (key in map.keys) {
                L.d("key值是：" + key + "  对应的具体值:" + map[key] + "\n")
//              将取出的QQ账户信息存储到SharedPreferences中
                ShareUtils.putString(this@LoginActivity, key, map[key])
            }
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            L.d("登录成功")
        }

        /**
         * 失败
         * @param platform
         * @param action
         * @param t
         */
        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {
            L.d("登录失败" + t.message)
        }

        /**
         * 取消登录的回调
         * @param platform
         * @param action
         */
        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            L.d("取消登录")
        }
    }

    /**
     * QQ登录必须加入此回调
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }
}
