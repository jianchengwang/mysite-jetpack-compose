package com.example.mysite.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.mysite.data.siteData
import com.example.mysite.ui.components.ClipImage

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Home Screen" }
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
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
        ClipImage(image, siteData.name, siteData.description)
    }
}

@Composable
fun About() {
    Column(
        modifier = Modifier.fillMaxWidth(0.8f)
    ) {
        Text("About Me", style = MaterialTheme.typography.subtitle2, color = MaterialTheme.colors.primary)
        Text(siteData.aboutMe, style = MaterialTheme.typography.body2)
        Spacer(Modifier.height(16.dp))
        Text("About Site", style = MaterialTheme.typography.subtitle2, color = MaterialTheme.colors.primary)
        Text(siteData.aboutSite, style = MaterialTheme.typography.body2)
    }
}

@Preview
@Composable
fun PreviewHomeBody() {
    HomeScreen()
}
