package com.example.administrator.kotlinrobot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.administrator.kotlinrobot.adapter.RecyclerViewAdapter
import com.example.administrator.kotlinrobot.bean.Ask
import com.example.administrator.kotlinrobot.bean.Chat
import com.example.administrator.kotlinrobot.bean.Take
import com.example.administrator.kotlinrobot.net.Api
import com.example.administrator.kotlinrobot.util.L

//加了这一行后我们就不需要再findViewById了
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 继承于AppCompatActivity()
 * 继承于View.OnClickListener接口，复写onClick点击事件
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    //    对话列表集合
    private var list = ArrayList<Chat>()

    //    recyclerView适配器
    private var recyclerViewAdapter = RecyclerViewAdapter(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       设置控件的回调监听
        init()
//       加载数据
        initData()
        //       设置recyclerView布局管理
        val linearLayoutManager = LinearLayoutManager(this)
//       把布局管理器添加到recyclerView中
        recycler.setLayoutManager(linearLayoutManager)
//       把适配器添加到recyclerView中
        recycler.setAdapter(recyclerViewAdapter)


    }

    /**
     * 设置控件的回调监听
     */
    private fun init() {
        btn_send.setOnClickListener(this)
    }

    /**
     * 重写OnClickListener接口的onClick方法
     */
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_send -> {
//                Toast.makeText(this, "你好，世界", Toast.LENGTH_LONG).show()
                /**
                 * 1,获取输入框的内容
                 * 2,判断是否为空
                 * 4,发送后清空当前的输入框
                 */
//               1，获取输入框的内容
                val text: String = et_text.text.toString()
//               2,判断是否为空
                if (!TextUtils.isEmpty(text)) {
                    addData(text, 1)
                    request(text)
                } else {
                    L.d("你的输入为空")
                }
            }
        }
    }

    /**
     * 通过传递进来的test和type创建数据实体类，添加到聊天数据集合list中
     * @param text 文本信息
     * @param type 标示类型
     */
    private fun addData(mtext: String, mtype: Int) {
        L.d("addData  mtext:" + mtext + "  mtype" + mtype)
        var c = Chat(mtext, mtype)
        list.add(c)
//      更新适配器，插入新数据
        recyclerViewAdapter.notifyItemInserted(list.size - 1)
//      把显示的位置定位到最后一行
        recycler.scrollToPosition(list.size - 1)
    }

    /**
     * 模拟加载数据
     */
    private fun initData() {
//      传入0到c1的type属性来表示该数据是接受到的数据，然后把实体类c1添加到对话列表集合中
        var c1: Chat = Chat("你好，我叫阿紫", 0)
        list.add(c1)
//      使用1到c2的type属性来表示该数据是输入框的发送数据,然后把实体类c2添加到对话列表集合中
        var c2: Chat = Chat("你好，你现在会些什么呢？", 1)
        list.add(c2)
//      接受数据
        var c3: Chat = Chat("我还在成长中，很多东西还不懂，但是你可以考考我\"", 0)
        list.add(c3)
//      发送数据
        var c4: Chat = Chat("1+1等于几?\"", 1)
        list.add(c4)
        //      接受数据
        var c5: Chat = Chat("1+1=2", 0)
        list.add(c5)
    }


    /**
     * 请求数据
     *
     */
    private fun request(mText: String) {
//      存储要发送的的文本
        var perceotion = Ask.Perception(Ask.Perception.InputText(mText))
//      设置用户id和ApidKey
        val userInfo = Ask.UserInfo("c00282de107144fb940adab994d9ff98", "225167")
//      填充到请求体Ask中
        var ask = Ask(0, perceotion, userInfo)

//      使用retiofit进行请求
        var retrofit = Retrofit.Builder()
                .baseUrl("http://openapi.tuling123.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//      创建网络请求接口的实例
        val api = retrofit.create(Api::class.java)
//
        val call = api.request(ask)

//
        call.enqueue(object : retrofit2.Callback<Take> {
            //          请求成功
            override fun onResponse(call: retrofit2.Call<Take>, response: Response<Take>) {
                //              接受到的机器人回复的数据
                L.d("返回的全部信息：" + response.body().toString())
                var text = response.body().results.get(0).values.text
                //在这里进行处理，防止接口没有返回数据时抛出异常
                if (text == null) {
                    text = "我还小，不知道这句话的意思"
                    //把接受到的数据传入addData方法中，类型是TYPE_RECEIVED接受数据
                    addData(text, 0)
                } else {
                    //把接受到的数据传入addData方法中，类型是TYPE_RECEIVED接受数据
                    addData(text, 0)
                }
                L.d("接受到的机器人回复的数据： " + text)
            }

            //            请求失败
            override fun onFailure(call: retrofit2.Call<Take>, t: Throwable) {
                L.d("请求失败： " + t.toString())
            }
        })
    }
}
