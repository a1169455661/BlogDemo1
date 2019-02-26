package com.example.administrator.base;

import com.facebook.stetho.Stetho;

/**
 * Created by 舍长 on 2018/4/27.
 */

public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        // 数据库文件查看框架
        Stetho.initializeWithDefaults(this);
    }
}
