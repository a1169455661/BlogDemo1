package com.example.administrator.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by 舍长 on 2018/4/27.
 */

public class FontSetting {
    public FontSetting() {
    }

    public static void setFont(Context context, TextView textView, String fontsPath) {
        try {
            Typeface fromAsset = Typeface.createFromAsset(context.getAssets(), fontsPath);
            textView.setTypeface(fromAsset);
        } catch (Exception e) {
            L.d("找不到文件资源！");
            Toast.makeText(context, "服务器出错啦！", Toast.LENGTH_SHORT).show();
        }
    }
}
