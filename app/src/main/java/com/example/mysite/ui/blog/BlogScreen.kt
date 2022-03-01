package com.example.mysite.ui.blog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mysite.MysiteViewModel
import com.example.mysite.data.Blog
import com.example.mysite.data.stores
import com.example.mysite.data.techs
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun BlogScreen(navController: NavHostController, viewModel: MysiteViewModel) {
    viewModel.noBottomBar = false
    viewModel.showTopBar = false

    val tabs = listOf("Tech", "Store")
    val pagerState = rememberPagerState()
    Scaffold(
    ) {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(navController = navController, tabs = tabs, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<String>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = { Icon(if(tab == "Tech") Icons.Filled.ThumbUp else Icons.Filled.Favorite, contentDescription = null) },
                text = { Text(tab) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(navController: NavHostController, tabs: List<String>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        if(tabs[page] == "Tech") {
            TechScreen(navController)
        } else {
            StoreScreen(navController)
        }
    }
}

@Composable
fun SearchView(search: MutableState<TextFieldValue>) {
    TextField(
        value = search.value,
        onValueChange = { value ->
            search.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (search.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        search.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            backgroundColor = MaterialTheme.colors.primary
        )
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BlogListScreen(navController: NavHostController, blogList: ArrayList<Blog>) {
    val search = remember { mutableStateOf(TextFieldValue("")) }
    var filterList: ArrayList<Blog>
    SearchView(search)
    Spacer(Modifier.height(4.dp))
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        val searchedText = search.value.text
        filterList = ArrayList<Blog>()
        for (blog in blogList) {
            if (searchedText.isEmpty() || blog.title.contains(searchedText)) {
                filterList.add(blog)
            }
        }
        items(filterList) {
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(10.dp),
                onClick = {
                    navController.navigate("blog/${it.title}")
                }
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = it.title, style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(16.dp))
                    Text(text = "#" + it.tags.joinToString(","), style = MaterialTheme.typography.subtitle2, color = MaterialTheme.colors.primaryVariant, fontStyle = FontStyle.Italic)
                }
            }
        }
    }
}

@Composable
fun TechScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BlogListScreen(navController, techs)
    }
}

@Composable
fun StoreScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BlogListScreen(navController, stores)
    }
}