package com.example.administrator.qqshare.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

/**
 * Created by 舍长 on 2018/5/28.
 * 舍长:
 * 全屏化基础Activity
 * 在kotlin中，一个类要能被子类继承，父类本身要加上open关键字
 */
open class WinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //      设置全屏
        win()
    }

    private fun win() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}
