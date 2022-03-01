package com.example.mysite.utils

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

suspend fun readTxt(url: String?): String
{
    val url = URL(url)
    val inputstreamreader = BufferedReader(InputStreamReader(url.openStream()))
    try {
        Log.e("获取网址文本内容---------", inputstreamreader.readLines().toString())
        return inputstreamreader.readLines().toString()
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    } finally {
        inputstreamreader.close()
    }
    return ""
}