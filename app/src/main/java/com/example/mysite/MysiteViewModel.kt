package com.example.mysite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MysiteViewModel: ViewModel() {
    var noBottomBar by mutableStateOf(false)
    var showTopBar by mutableStateOf(false)
    var topBarTitle by mutableStateOf("")
}