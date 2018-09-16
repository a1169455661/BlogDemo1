package com.example.tonjies.kotlinpractice2.util

import android.util.Log

/**
 * 在kotlin中，加了object后，L类就成为了一个单例模式的类，相当于帮我们省略掉了以前Java实现单例的代码
 * 最后我们可以直接L.d调用类中的方法
 */
object L {
    //过滤词
    val TAG:String="tonjies"
    //5个等级 DIWE

    fun d(text: String) {
        Log.d(TAG, text + "")
    }
}