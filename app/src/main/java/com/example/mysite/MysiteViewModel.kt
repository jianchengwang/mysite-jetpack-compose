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
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    @GET("{markdownFile}")
    fun loadText(@Path("markdownFile") markdownFile: String): Call<String>
}

class MysiteViewModel: ViewModel() {
    var noBottomBar by mutableStateOf(false)
    var showTopBar by mutableStateOf(false)
    var topBarTitle by mutableStateOf("")

    var currentBlog: MutableLiveData<Blog> = MutableLiveData(Blog())
    var currentBlogMd: MutableLiveData<String> = MutableLiveData("")
    var currentBook: MutableLiveData<Book> = MutableLiveData(Book())

    fun startBlog(title: String) {
        var baseUrl = "https://raw.githubusercontent.com/jianchengwang/my-site/main/nuxtsite/content/tech/"
        topBarTitle = title
        currentBlog.value = techs.find { it.title.equals(title) }
        if(currentBlog.value == null) {
            currentBlog.value = stores.find { it.title.equals(title) }
            baseUrl = "https://raw.githubusercontent.com/jianchengwang/my-site/main/nuxtsite/content/store/"
        }
        viewModelScope.launch {
            val okHttpClient = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
            val networkService: NetworkService = retrofit.create(NetworkService::class.java)
            currentBlog.value?.let { networkService.loadText(it.markdownFile) }
                ?.enqueue(object : Callback<String?> {
                    override fun onResponse(call: Call<String??>?, response: Response<String?>?) {
                        if (response != null) {
                            currentBlogMd.value = response.body().toString()
                        }
                    }
                    override fun onFailure(call: Call<String?>?, t: Throwable?) {
                        //失败
                        currentBlogMd.value = "获取文件失败"
                    }
                })
        }
    }
}