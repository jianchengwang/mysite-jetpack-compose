package com.example.mysite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysite.data.Blog
import com.example.mysite.data.Book
import com.example.mysite.data.stores
import com.example.mysite.data.techs
import com.example.mysite.utils.readTxt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MysiteViewModel: ViewModel() {
    var noBottomBar by mutableStateOf(false)
    var showTopBar by mutableStateOf(false)
    var topBarTitle by mutableStateOf("")

    var currentBlog: MutableLiveData<Blog> = MutableLiveData(Blog())
    var currentBlogMd: MutableLiveData<String> = MutableLiveData("")
    var currentBook: MutableLiveData<Book> = MutableLiveData(Book())

    fun startBlog(title: String) {
        topBarTitle = title
        currentBlog.value = techs.find { it.title.equals(title) }
        if(currentBlog.value == null) {
            currentBlog.value = stores.find { it.title.equals(title) }
        }
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                if (currentBlog.value != null) {
                    currentBlogMd.postValue(readTxt(currentBlog.value?.contentUrl))
                }
            }
        }
    }
}