package com.example.administrator.qqshare.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by 舍长 on 2018/5/28.
 * 舍长:SharedPreferences封装类
 */
public class ShareUtils {

    public static final String NAME = "config";

    //存储
    public static void putString(Context mContext, String key, String value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    //获取
    public static String getString(Context mContext, String key, String defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }


    //存储
    public static void putInt(Context mContext, String key, int value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).commit();
    }

    //获取
    public static int getInt(Context mContext, String key, int defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    //存储
    public static void putBoolean(Context mContext, String key, boolean value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    //获取
    public static boolean getBoolean(Context mContext, String key, Boolean defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }

    //删除 单个
    public static void deleShare(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }

    //删除全部
    public static void deleAll(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }
}
