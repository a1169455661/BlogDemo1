package com.example.administrator.kotlinrobot.net

import com.example.administrator.kotlinrobot.bean.Ask
import com.example.administrator.kotlinrobot.bean.Take

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by 舍长 on 2018/5/25.
 * 舍长:
 */
interface Api {
    //发送json数据形式的post请求，把网络请求接口的后半部分openapi/api/v写在里面
    //Ask是请求数据实体类，Take接受数据实体类
    @POST("openapi/api/v2")
    fun request(@Body ask: Ask): Call<Take>
}