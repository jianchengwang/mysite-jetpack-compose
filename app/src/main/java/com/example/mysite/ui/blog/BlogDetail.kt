package com.example.mysite.ui.blog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysite.data.stores
import com.example.mysite.data.techs
import com.example.mysite.utils.readTxt
import dev.jeziellago.compose.markdowntext.MarkdownText
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BlogDetailScreen(title: String, scaffoldState: ScaffoldState = rememberScaffoldState()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        val scope = rememberCoroutineScope()
        var markdownContent = remember { mutableStateOf("") }
        var blog = techs.find { it -> it.title.equals(title) }
        if(blog == null) {
            blog = stores.find { it -> it.title.equals(title) }
        }
        if (blog != null) {
            LaunchedEffect(blog.contentUrl) {
                scope.launch {
                    markdownContent.value = readTxt(blog.contentUrl)
                }
            }
        } else {
            Text("empty")
        }
        if(markdownContent.value.isNotEmpty()) {
            MarkdownText(
                modifier = Modifier.padding(8.dp),
                markdown = markdownContent.value,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = LocalContentColor.current,
                maxLines = 3,
                style = MaterialTheme.typography.overline
            )
        }
    }
}
