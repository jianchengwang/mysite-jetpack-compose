package com.example.mysite

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class MysiteScreen(val icon: ImageVector) {
    Home(
        icon = Icons.Filled.Home
    ),
    Blog(
        icon = Icons.Filled.List
    ),
    Book(
        icon = Icons.Filled.Share
    ),
    Girl(
        icon = Icons.Filled.Face
    );

    companion object {
        fun fromRoute(route: String?): MysiteScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                Blog.name -> Blog
                Book.name -> Book
                Girl.name -> Girl
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}