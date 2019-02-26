package com.example.administrator.app.module.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.administrator.app.R
import com.example.administrator.app.util.L

/**
 * 跳转后的界面
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("20")
        Log.d("tonjies", "name: " + name + " age:" + 20)
    }
}
