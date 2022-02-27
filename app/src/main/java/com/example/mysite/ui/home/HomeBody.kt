package com.example.mysite.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysite.R
import com.example.mysite.ui.components.ClipImage

@Composable
fun HomeBody() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Home Screen" }
            .fillMaxWidth(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AvatarImage()
        Spacer(Modifier.height(16.dp))
        About()
    }
}

@Composable
fun AvatarImage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image: Painter = painterResource(id = R.drawable.avatar)
        ClipImage(image, "JianchengWang", "Have fun and enjoy every day.")
    }
}

@Composable
fun About() {
    Column(
        modifier = Modifier.fillMaxWidth(0.8f),
    ) {
        Text("About Me", style = MaterialTheme.typography.subtitle2)
        Text("奔三大龄男青年，职业码农，立志全栈，技术九流，没啥兴趣爱好，一般刷剧，看书 沉迷网络小说，dota2，跑步，滑板，宅狗一枚，周末一般躺尸不出门", style = MaterialTheme.typography.body2)
        Spacer(Modifier.height(16.dp))
        Text("About Site", style = MaterialTheme.typography.subtitle2)
        Text("个人博客，简单记录一下技术，生活上的东东，偶尔会发些莫名其妙的东西，什么类型都有，主要关注以下几点" +
                "\n" +
                "1.编码\n" +
                "2.生活牢骚，不喷不快\n" +
                "3.自己会发光的东西\n" +
                "4.武侠小说，妈的，来场穿越吧，要求不高，一座城堡，十个老婆，一剑光耀十九州\n" +
                "5.分享杂谈，读书笔记等", style = MaterialTheme.typography.body2)
    }
}

@Preview
@Composable
fun PreviewHomeBody() {
    HomeBody()
}
