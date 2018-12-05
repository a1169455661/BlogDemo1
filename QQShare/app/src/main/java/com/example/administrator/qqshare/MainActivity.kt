package com.example.administrator.qqshare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.administrator.qqshare.base.WinActivity
import com.example.administrator.qqshare.module.login.LoginActivity
import com.example.administrator.qqshare.util.L
import com.example.administrator.qqshare.util.ShareUtils
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA

//绑定控件
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by 舍长 on 2018/5/28.
 * 舍长:个人信息页面
 */
class MainActivity : WinActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      加载用户信息
        initData()
//      注销账号
        LogOut()
    }

    /**
     * 退出账户
     */
    private fun LogOut() {
        mLogOut.setOnClickListener(View.OnClickListener {
            UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, object : UMAuthListener {
                /**
                 * 成功
                 */
                override fun onComplete(p0: SHARE_MEDIA?, p1: Int, p2: MutableMap<String, String>?) {
                    L.d("注销回调:成功")
                }

                override fun onCancel(p0: SHARE_MEDIA?, p1: Int) {
                    L.d("注销回调:取消")
                }

                override fun onError(p0: SHARE_MEDIA?, p1: Int, p2: Throwable?) {
                    L.d("注销回调:取消")
                }

                override fun onStart(p0: SHARE_MEDIA?) {
                }

            })
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        })
    }

    /**
     * 加载用户信息
     */
    private fun initData() {
        //      QQ昵称
        val screen_name = ShareUtils.getString(this, "name", "")
        //      性别
        val gender = ShareUtils.getString(this, "gender", "")
        //      省份
        val province = ShareUtils.getString(this, "province", "")
        //      城市
        val city = ShareUtils.getString(this, "city", "")
        //      头像地址
        val iconurl = ShareUtils.getString(this, "iconurl", "http://p5olxq226.bkt.clouddn.com//test_user_logo.jpeg")


        //      用户昵称
        mUsername.setText(screen_name)

        //      用户性别
        mUserSex.setText(gender)

        //      用户地区
        mUserArea.setText(province + " " + city)

        //       用户头像
        Glide.with(this).load(iconurl).into(mUserLogo)
    }
}
