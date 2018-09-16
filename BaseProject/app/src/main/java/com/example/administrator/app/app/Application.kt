package com.example.administrator.app.app

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by 舍长 on 2018/6/9.
 * 舍长:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}