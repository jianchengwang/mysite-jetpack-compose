package com.example.mysite.ui.blog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysite.MysiteViewModel
import com.example.ui.theme.AppTypography
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
    ) {
        val currentBlogMd: State<String> = viewModel.currentBlogMd.observeAsState() as State<String>
        viewModel.startBlog(title)
        MarkdownText(
            modifier = Modifier.padding(12.dp),
            markdown = currentBlogMd.value,
            textAlign = TextAlign.Start,
            color = LocalContentColor.current,
            style = AppTypography.bodyMedium
        )
    }
}
