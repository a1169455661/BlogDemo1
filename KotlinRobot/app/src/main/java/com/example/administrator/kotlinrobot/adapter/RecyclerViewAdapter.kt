package com.example.administrator.kotlinrobot.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.administrator.kotlinrobot.R
import com.example.administrator.kotlinrobot.bean.Chat
import com.example.administrator.kotlinrobot.util.L


/**
 * Created by 舍长 on 2018/5/7.
 * 描述: 聊天布局适配器
 */

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    //    上下文
    private var context: Context? = null

    //    对话列表
    private var mlist: List<Chat>? = null

    constructor() {

    }

    constructor(context: Context, list: List<Chat>) {
        this.context = context
        this.mlist = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = mlist!![position]
        if (chat.type == 0) {
            L.d("左边的" + chat.text)
            //           如果收的的数据是左边，就显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.visibility = View.VISIBLE
            holder.rightLayout.visibility = View.GONE
//            把文本设置到机器人对话框内
            holder.leftChat.setText(chat.text)
            //
        } else if (chat.type == 1) {
            L.d("右边的" + chat.text)
            //           如果发出的消息是右边，就显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.visibility = View.VISIBLE
            holder.leftLayout.visibility = View.GONE
//            把文本设置到用户对话框内
            holder.rightChat.setText(chat.text)
        }
    }

    override fun getItemCount(): Int {
        return mlist!!.size
    }

    /**
     * 声明控件
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var leftLayout: LinearLayout
        var rightLayout: LinearLayout
        var leftChat: TextView
        var rightChat: TextView

        init {
            leftLayout = itemView.findViewById(R.id.left_layout)
            rightLayout = itemView.findViewById(R.id.right_layout)
            leftChat = itemView.findViewById(R.id.tv_left_text)
            rightChat = itemView.findViewById(R.id.tv_right_text)
        }
    }
}
