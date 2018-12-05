package com.example.administrator.qqshare.module.share

import android.Manifest
import android.app.PendingIntent.getActivity
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.example.administrator.qqshare.R
import com.example.administrator.qqshare.util.L
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.umeng.socialize.media.UMusic
import com.umeng.socialize.shareboard.SnsPlatform
import com.umeng.socialize.utils.ShareBoardlistener
import kotlinx.android.synthetic.main.activity_share.*
import org.jetbrains.anko.toast


/**
 * Created by 舍长 on 2018/12/03.
 * 友盟社会化分享
 */
class ShareActivity : AppCompatActivity() {

    private var mShareAction: ShareAction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        //判断是否已经获取到了权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //没有的话弹出权限获取框
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }
        //匿名内部类实现点击事件
        btnShare.setOnClickListener {
            shares()
        }
    }

    /**
     * 调起分享面板
     */
    private fun shares() {
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
                        //分享链接
//                        shareUrl(share_media)
                        //分享的图片
//                        image(share_media)
                        //分享音乐
                           music()
                    }
                })
        mShareAction?.open()//开始分享
    }

    fun music() {
        val music = UMusic("http://pj67ii310.bkt.clouddn.com/lijun.mp3")
        music.title = "This is music title"
        music.setThumb(UMImage(this@ShareActivity, R.drawable.book))
        music.description = "my description"
        music.setmTargetUrl("http://mobile.umeng.com/social")
        ShareAction(this@ShareActivity).withMedia(music)
                .setPlatform(SHARE_MEDIA.QQ)
                .setCallback(shareListener).share()
    }

    /**
     * 分享图片
     */
    fun image(share_media: SHARE_MEDIA?) {
        val imageUrl = UMImage(this@ShareActivity, "https://s.yimg.com/xd/api/res/1.2/Hq_PBh70vP17cUVnaLeWTw--/YXBwaWQ9eXR3YXVjdGlvbnNlcnZpY2U7aD0yMDAwO3E9ODU7cm90YXRlPWF1dG87dz0xMzMz/https://s.yimg.com/ob/image/c4bf19f0-93c8-463f-83a8-8eae5d648b88.jpg")
        imageUrl.setThumb(UMImage(this@ShareActivity, R.drawable.book))//缩略图
        ShareAction(this@ShareActivity)
                .withMedia(imageUrl)
                .setPlatform(share_media)//设置分享的平台
                .setCallback(shareListener)
                .share()
    }

    /**
     * 分享url
     */
    fun shareUrl(share_media: SHARE_MEDIA?) {
        val web = UMWeb("https://www.jianshu.com/u/8c6b4be8770b")//你要分享的url
        web.mText = "tonjie的博客"//分享内容的标题
        web.description = "tonjies的博客，会每周分享一些开发知识"//分享内容的描述
        web.setThumb(UMImage(this@ShareActivity, R.drawable.book))//分享内容的缩略图
        ShareAction(this@ShareActivity)
                .withMedia(web)
                .setPlatform(share_media)//设置分享的平台
                .setCallback(shareListener)
                .share()
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
