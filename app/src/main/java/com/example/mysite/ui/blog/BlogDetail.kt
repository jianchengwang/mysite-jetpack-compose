package com.example.mysite.ui.blog

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.example.mysite.MysiteViewModel
import com.example.mysite.data.Blog
import dev.jeziellago.compose.markdowntext.MarkdownText

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BlogDetailScreen(viewModel: MysiteViewModel, title: String, scaffoldState: ScaffoldState = rememberScaffoldState()) {
    viewModel.noBottomBar = true
    viewModel.showTopBar = true
    viewModel.topBarTitle = title
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        viewModel.startBlog(title)
        val currentBlogMd: State<String?> = viewModel.currentBlogMd.observeAsState()
        currentBlogMd.value?.let { Log.e("currentBlog", it) }
        currentBlogMd.value?.let {
            MarkdownText(
                modifier = Modifier.padding(8.dp),
                markdown = it,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = LocalContentColor.current,
                maxLines = 3,
                style = MaterialTheme.typography.overline
            )
        }

    }
}
