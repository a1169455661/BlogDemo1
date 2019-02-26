package com.example.administrator.app.view

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

/**
 * Created by 舍长 on 2018/6/24.
 * 舍长:自定义控件
 */
class Views : View {

    constructor(context: Context) : super(context)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
}