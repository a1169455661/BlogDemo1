package com.example.administrator.app.module.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.administrator.app.R
import com.example.administrator.app.util.L
import com.example.administrator.app.util.ShareUtils
import kotlinx.android.synthetic.main.activity_anko.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_share.*

/**
 * sharedPreferences封装类测试
 */
class ShareActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        init()
    }


    /**
     * 虽然我们通过import kotlinx.android.synthetic.main.activity_anko.*使得不需要写控件的fndId，
     * 但是我们仍然是要写setOnClickListener(this)控件点击回调监听的
     */
    private fun init() {
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn1 -> {
//              存储String类型
                ShareUtils.putString(this, "name", "tonjie")
                ShareUtils.putString(this, "age", "20")
                toast("A")
            }
//              取出String类型
            R.id.btn2 -> {
                val name = ShareUtils.getString(this, "name", "20")
                L.d("name:  " + name)
            }
            R.id.btn3 -> {
//              删除单个key
                ShareUtils.deleShare(this, "name")
            }
            R.id.btn4 -> {
//              删除所有key
                ShareUtils.deleAll(this)
            }
        }
    }
}
