package com.example.administrator.kotlinrobot.bean


/**
 * 返回数据响应体实体类
 */
data class Take(
        val emotion: Emotion,
        val intent: Intent,
        val results: List<Result>
) {
    data class Emotion(
            val robotEmotion: RobotEmotion,
            val userEmotion: UserEmotion
    ) {
        data class UserEmotion(
                val a: Int,
                val d: Int,
                val emotionId: Int,
                val p: Int
        )

        data class RobotEmotion(
                val a: Int,
                val d: Int,
                val emotionId: Int,
                val p: Int
        )
    }

    data class Result(
            val groupType: Int,
            val resultType: String,
            val values: Values
    ) {
        //      返回文本 "叫我阿紫就可以了"
        data class Values(
                val text: String
        )
    }

    data class Intent(
            val actionName: String,
            val code: Int,
            val intentName: String
    )
}