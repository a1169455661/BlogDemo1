package com.example.administrator.editview.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.EditText
import com.example.administrator.editview.R
import com.example.administrator.editview.util.L

/**
 * Created by 舍长 on 2018/6/24.
 * 舍长:一键清除内容输入框
 */
class ClearEditText : EditText {

    //   声明Drawable类
    private var drawable: Drawable? = null

    constructor(context: Context) : super(context)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //在init方法类设置删除图片和监听输入框得的状态
        init()
    }

    /**
     * 设置图片以及监听输入框的改变
     */
    private fun init() {
        drawable = ContextCompat.getDrawable(context, R.drawable.ic_clear_black_24dp)
        addTextChangedListener(object : TextWatcher {

            /**
             * 文本即将改变，在回调中最先被调用
             * 由于每修改一次，就会触发TextWatcher()回调，所以count属性和after属性不能很直观的同步测试出来，
             * 如果有谁知道解决方法麻烦留言告诉我
             * @param charSequence 改变之前的字符
             * @param start 改变的位置
             * @param count 旧文本长度
             * @param after 新文本的长度
             */
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
                //                L.d("改变之前的文本：" + charSequence+" 开始改变的位置"+start);
                //                L.d("旧文本长度：" + count+" 新文本的长度"+after);
            }

            /**
             * 文本开始改变，第二个被调用
             * @param charSequence 改变了之后的文本
             * @param start  改变的位置
             * @param before 旧字符长度
             * @param count  新字符长度
             */
            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                //                L.d("改变之后的文本：" + charSequence+" 改变的位置坐标"+start);
                //                L.d("旧文本长度：" + count+" 新文本的长度"+count);
            }

            /**
             * 文本修改完成，最后被调用
             * @param s 修改后的文本
             */
            override fun afterTextChanged(s: Editable) {
                setDrawable()
            }
        })
    }

    /**
     * 设置图片
     */
    private fun setDrawable() {
        if (length() > 1) {
            /**
             * 四个参数的意思是从左边，顶部，右边，底部添加图片，我们的删除突变是在右边的，所以我们把drawable填到第三个参数
             */
            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        }
    }

    /**
     * 触摸事件监听
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        //当drawable实例不为空，手指抬起事件
        if (drawable != null && event.action == MotionEvent.ACTION_UP) {
            //返回触摸到的
        }
        return super.onTouchEvent(event)
    }
}