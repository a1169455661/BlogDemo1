package com.example.administrator.qqshare.module.share

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import com.example.administrator.qqshare.R
import com.example.administrator.qqshare.util.L
import com.umeng.commonsdk.proguard.g.C
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.umeng.socialize.media.UMusic
import com.umeng.socialize.shareboard.ShareBoardConfig
import com.umeng.socialize.shareboard.SnsPlatform
import com.umeng.socialize.utils.ShareBoardlistener
import kotlinx.android.synthetic.main.activity_menu.*
import org.jetbrains.anko.toast

/**
 * 测试友盟不同位置分享框的Activity
 * 1，底部带白色背景图标
 * 2，底部不带白色背景图标
 * 3，中部带白色背景图标
 * 3，中部不带白色背景图标
 */
class MenuActivity : AppCompatActivity(), View.OnClickListener {

    private var mShareAction: ShareAction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //获得权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //没有的话弹出权限获取框
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }
        //初始化控件
        initView()
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        btn_01.setOnClickListener(this)
        btn_02.setOnClickListener(this)
        btn_03.setOnClickListener(this)
        btn_04.setOnClickListener(this)
        //配置分享面板
        mShareAction = ShareAction(this)
                .withText("你好，世界")
                .setDisplayList(
                        //传入展示列表
                        SHARE_MEDIA.QQ,//QQ
                        SHARE_MEDIA.QZONE,//QQ
                        SHARE_MEDIA.WEIXIN, //微信
                        SHARE_MEDIA.WEIXIN_CIRCLE,//微信朋友圈
                        SHARE_MEDIA.WEIXIN_FAVORITE//微信收藏
                ).setShareboardclickCallback(object : ShareBoardlistener {
                    override fun onclick(snsPlatform: SnsPlatform?, share_media: SHARE_MEDIA?) {
                        val web = UMWeb("https://www.jianshu.com/u/8c6b4be8770b")//你要分享的url
                        web.mText = "tonjies的博客"//分享内容的标题
                        web.description = "tonjies的博客，会每周分享一些开发知识"//分享内容的描述
                        web.setThumb(UMImage(this@MenuActivity, R.drawable.book))//分享内容的缩略图
                        ShareAction(this@MenuActivity)
                                .withMedia(web)
                                .setPlatform(share_media)//设置分享的平台
                                .setCallback(shareListener)
                                .share()
                    }
                })
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_01 -> {
//                toast("1")
                mShareAction?.open()
            }
            R.id.btn_02 -> {
//                toast("2")
                var config: ShareBoardConfig = ShareBoardConfig()
                config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE)//底部菜单，图标无白色圆圈
                mShareAction?.open(config)
            }
            R.id.btn_03 -> {
//                toast("3")
                var config: ShareBoardConfig = ShareBoardConfig()
                config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER)
                config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_CIRCULAR)//中部菜单，有白色圆圈
                mShareAction?.open(config)
            }
            R.id.btn_04 -> {
//                toast("4")
                val config = ShareBoardConfig()
                config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER)
                config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE)//中部菜单，无白色圆圈
                mShareAction?.open(config)
            }
        }
    }

    //分享的回调
    private val shareListener = object : UMShareListener {

        //开始分享，platform为平台类型
        override fun onStart(platform: SHARE_MEDIA) {
            L.d("开始分享，分享的平台是：$platform");
        }

        //分享成功
        override fun onResult(platform: SHARE_MEDIA) {
            L.d("分享成功")
            toast("分享成功")
        }

        //分享失败
        override fun onError(platform: SHARE_MEDIA, t: Throwable) {
            toast("分享失败,失败的原因是$t")
        }

        //分享取消了
        override fun onCancel(platform: SHARE_MEDIA) {
            toast("分享取消了")
        }
    }

}
