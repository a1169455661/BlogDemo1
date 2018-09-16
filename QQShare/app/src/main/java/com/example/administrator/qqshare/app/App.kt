package com.example.administrator.qqshare.app

import android.app.Application
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig


/**
 * Created by 舍长 on 2018/5/28.
 * 舍长: 自定义Applciation
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //        友盟统计
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this,"5afa5748f43e480cf40000a8"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"")
        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true)
    }

    /**
     * 代码块
     * 101476089 为AppId
     * bf12db860a21d9e0ce217b37cbc1dec7为AppKey
     */
    init {
        PlatformConfig.setQQZone("101476089", "bf12db860a21d9e0ce217b37cbc1dec7")
    }
}