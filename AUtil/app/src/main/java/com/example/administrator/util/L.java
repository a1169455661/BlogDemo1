package com.example.administrator.util;

import android.util.Log;

/**
 * Created by 舍长 on 2018/2/22.
 * 描述:Log设置类
 * 引用至:https://www.jianshu.com/p/6784800b5cc9
 */

public class L {

    //TAG
    public static String TAG = "tonjies";

    //5个等级 DIWE

    public static void d(String text) {
        Log.d(TAG, text + "");
    }

    public static void i(String text) {
        Log.i(TAG, text + "");
    }

    public static void w(String text) {
        Log.w(TAG, text + "");
    }

    public static void e(String text) {
        Log.e(TAG, text + "");
    }

}
