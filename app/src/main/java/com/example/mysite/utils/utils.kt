package com.example.mysite.utils

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun readTxt(url: String?): String
{
    val url = URL(url)
    val inputstreamreader = BufferedReader(InputStreamReader(url.openStream()))
    try
    {
        Log.e("获取网址文本内容---------", inputstreamreader.readLines().toString())
        return inputstreamreader.readLines().toString()
    }
    catch (e: java.lang.Exception)
    {
        e.printStackTrace()
    }
    finally
    {
        inputstreamreader.close()
    }
    return "读取失败,请检查文件名称及文件是否存在!"
}