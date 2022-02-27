package com.example.mysite

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mysite.live2d.Live2dActivity
import com.example.mysite.ui.girl.GirlBody
import com.example.mysite.ui.home.HomeBody
import com.example.mysite.ui.theme.MysiteTheme

class MysiteActivity : ComponentActivity() {

    private val viewModel: MysiteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MysiteApp(viewModel)
        }
    }
}

@Composable
fun MysiteApp(viewModel: MysiteViewModel) {
    MysiteTheme {
        val allScreens = MysiteScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = MysiteScreen.fromRoute(
            backstackEntry.value?.destination?.route
        )
        Scaffold(
            bottomBar = {
                if(!viewModel.noBottomBar) {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        allScreens.forEach { screen ->
                            BottomNavigationItem(
                                icon = { Icon(screen.icon, contentDescription = null) },
                                label = { Text(screen.name) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.name } == true,
                                onClick = {
                                    navController.navigate(screen.name) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            }

        ) { innerPadding ->
            MysiteNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun MysiteNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = MysiteScreen.Home.name,
        modifier = modifier
    ) {
        composable(MysiteScreen.Home.name) {
            HomeBody()
        }
        composable(MysiteScreen.Blog.name) {
            Text(text = "Blog")
        }
        composable(MysiteScreen.Book.name) {
            Text(text = "Book")
        }
        composable(MysiteScreen.Girl.name) {
            GirlBody()
            Text(text = "Girl")
            Button(onClick = {
                context.startActivity(Intent(context, Live2dActivity::class.java))
            }) {
                Text(text = "live2d")
            }
        }
    }
}
