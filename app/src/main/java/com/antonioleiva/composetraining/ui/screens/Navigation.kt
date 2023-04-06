package com.antonioleiva.composetraining.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.composetraining.ui.screens.home.Home
import com.antonioleiva.composetraining.ui.screens.login.Login

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Screen {
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route
        ) {
            composable(Screen.Login.route) { backStackEntry ->
                Login(onLoggedIn = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(backStackEntry.destination.id) {
                            inclusive = true
                        }
                    }
                })
            }
            composable(Screen.Home.route) {
                Home()
            }
        }
    }
}