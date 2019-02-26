package com.example.administrator.app.module.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.administrator.app.R

import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

//加入这一行后，控件就不需要findId啦
import kotlinx.android.synthetic.main.activity_anko.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

/**
 * Anko测试Activity
 */
class AnkoActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko)
        init()
    }

    /**
     * 虽然我们通过import kotlinx.android.synthetic.main.activity_anko.*使得不需要写控件的fndId，
     * 但是我们仍然是要写setOnClickListener(this)控件点击回调监听的
     */
    private fun init() {
        btn_01.setOnClickListener(this)
        btn_02.setOnClickListener(this)
        btn_03.setOnClickListener(this)
        btn_04.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_01 -> {
//          短吐司原来的写法
//                Toast.makeText(this, "原生的吐司", Toast.LENGTH_SHORT).show()
//          使用Anko的写法
                toast("Anko的短吐司")
            }
            R.id.btn_02 -> {
//          长吐司原来的写法
//                Toast.makeText(this, "原生的吐司", Toast.LENGTH_LONG).show()
//          使用Anko的写法
                longToast("Anko的长吐司")
            }
            R.id.btn_03 -> {
//          原生跳转
//                startActivity(Intent(this@AnkoActivity, SecondActivity::class.java))
//          Anko跳转
                startActivity<SecondActivity>()
            }
            R.id.btn_04 -> {
//          原生携带数据跳转
//                val intent = Intent(this, SecondActivity::class.java)
//                intent.putExtra("name", 5)
//                startActivity(intent)
//           Anko携带数据跳转
                startActivity<SecondActivity>("name" to "tonjie", "age" to 20)
            }
        }
    }
}
