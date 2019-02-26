package com.example.tonjies.kotlinpractice2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tonjies.kotlinpractice2.util.L
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btnLog.setOnClickListener(this)
        btnToasts.setOnClickListener(this)
        btnToastL.setOnClickListener(this)
        btnNet.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLog -> {
                //加了object关键字后成为了单例模式的类，直接类名.方法调用即可
                L.d("你好，世界")
            }
            R.id.btnToasts -> {
                toast("短吐司")
            }
            R.id.btnToastL -> {
                longToast("长吐司")
            }
            R.id.btnNet -> {

            }
        }
    }

}
