package com.example.administrator.app.util

import android.content.Context

/**
 * Created by 舍长 on 2018/6/9.
 * 舍长:sharedPreferences封装类
 */
object ShareUtils {

    val NAME = "config"


    /**
     * 存储String类型的值
     * @param mContext this
     * @param key      key值
     * @param value    要存储的String值
     */
    fun putString(mContext: Context, key: String, value: String) {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(key, value).commit()
    }

    /**
     * 获取String类型的值
     * @param mContext this
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    fun getString(mContext: Context, key: String, defValue: String): String? {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, defValue)
    }


    /**
     * 存储Int类型的值
     * @param mContext this
     * @param key      key
     * @param value    要存储的Int值
     */
    fun putInt(mContext: Context, key: String, value: Int) {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt(key, value).commit()
    }


    /**
     * 获取Int类型的值
     * @param mContext this
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    fun getInt(mContext: Context, key: String, defValue: Int): Int {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key, defValue)
    }


    /**
     * 存储Boolean类型的值
     * @param mContext this
     * @param key      key
     * @param value    要存储Boolean值
     */
    fun putBoolean(mContext: Context, key: String, value: Boolean) {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(key, value).commit()
    }

    /**
     * 获取Boolean类型的值
     * @param mContext this
     * @param key      key
     * @param defValue 默认值
     * @return
     */
    fun getBoolean(mContext: Context, key: String, defValue: Boolean?): Boolean {
        val sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, defValue!!)
    }

    //删除 单个 key
    fun deleShare(context: Context, key: String) {
        val sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(key).commit()
    }

    //删除全部 key
    fun deleAll(context: Context) {
        val sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()
    }
}