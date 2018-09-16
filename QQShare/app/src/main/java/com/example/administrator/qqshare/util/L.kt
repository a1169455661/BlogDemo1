package com.example.administrator.qqshare.util

import android.util.Log


/**
 * Created by 舍长 on 2018/5/28.
 * 舍长:
 * 在kotlin中，加了object后，L类就成为了一个单例模式的类，相当于帮我们省略掉了以前Java实现单例的代码
 * 最后我们可以直接L.d调用类中的方法
 */
object L {
    //    TAG
    public var TAG: String = "tonJies"

    fun d(test: String) {
        Log.d(TAG, test)
    }
}