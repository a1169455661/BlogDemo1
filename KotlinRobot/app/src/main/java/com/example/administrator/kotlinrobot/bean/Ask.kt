package com.example.administrator.kotlinrobot.bean

/**
 * 请求数据请求体实体类
 * reqType 传0就行
 */
data class Ask(val reqType: Int,
        val perception: Perception,
        val userInfo: UserInfo
) {
    data class Perception(
            val inputText: InputText
    ) {
//      要发送的文本消息
        data class InputText(
                val text: String
        )
    }

    data class UserInfo(
//          机器人apiKey
            val apiKey: String,
//          用户id
            val userId: String
    )
}