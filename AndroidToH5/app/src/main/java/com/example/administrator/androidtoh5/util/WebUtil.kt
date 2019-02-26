package com.example.administrator.androidtoh5.util

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Created by 舍长 on 2018/7/1.
 * 舍长:项目帮助类
 */
object WebUtil {
    /**
     * 该方法的作用是读取assets文件夹下的html文件，转成String类型返回
     */
    fun getHtml(fileName: String, context: Context): String {
        //将json数据变成字符串
        var stringBuillder = StringBuffer()
        try {
            //获取assets资源管理器
            val assetManger = context.assets
            //通过管理器打开文件并读取
            val bf = BufferedReader(InputStreamReader(assetManger.open(fileName)))
            var line: String?
            do {
                line = bf.readLine()

                if (line == null) {
                    break
                }
                stringBuillder.append(line)
            } while (true)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuillder.toString()
    }
}