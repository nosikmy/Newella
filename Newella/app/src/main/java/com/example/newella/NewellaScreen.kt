package com.example.newella

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newella.ui.auth.AuthScreen
import com.example.newella.ui.library.LibraryScreen
import com.example.newella.ui.profile.ProfileScreen
import com.example.newella.ui.registration.RegistrationScreen
import com.example.newella.ui.search.SearchScreen
import com.example.newella.ui.start.StartScreen


enum class NewellaScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Auth(title = R.string.auth),
    Registration(title = R.string.registration),
    Library(title = R.string.library),
    Profile(title = R.string.profile),
    Search(title = R.string.search),
}


sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("start", Icons.Default.Home, "Главная")
    object Search : BottomNavItem("search", Icons.Default.Search, "Поиск")
    object Library : BottomNavItem("library", Icons.Default.Star, "Библиотека")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Профиль")
}



@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Library,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) },
                selectedContentColor = MaterialTheme.colorScheme.inversePrimary,
                unselectedContentColor = MaterialTheme.colorScheme.inversePrimary,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



@Composable
fun NewellaApp (
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NewellaScreen.valueOf(
        backStackEntry?.destination?.route ?: NewellaScreen.Start.name
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController
            )
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NewellaScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = NewellaScreen.Start.name) {
                StartScreen(
                    onNextButtonClicked = {
                        navController.navigate(NewellaScreen.Registration.name)
                    },

                )
            }
            composable(route = NewellaScreen.Auth.name) {
                AuthScreen(
                    onToRegistrationClick = {
                        navController.navigate(NewellaScreen.Registration.name)
                    },
                )
            }
            composable(route = NewellaScreen.Registration.name) {
                RegistrationScreen(
                    onToAuthClick = {
                        navController.navigate(NewellaScreen.Auth.name)
                    },
                )
            }
            composable(route = NewellaScreen.Library.name) {
                LibraryScreen(
                )
            }
            composable(route = NewellaScreen.Profile.name) {
                ProfileScreen(
                )
            }
            composable(route = NewellaScreen.Search.name) {
                SearchScreen(
                )
            }
        }

    }
}