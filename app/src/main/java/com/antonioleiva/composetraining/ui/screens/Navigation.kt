package com.antonioleiva.composetraining.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.composetraining.ui.screens.home.Home
import com.antonioleiva.composetraining.ui.screens.login.Login

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") { backStackEntry ->
            Login(onLoggedIn = {
                navController.navigate("home") {
                    popUpTo(backStackEntry.destination.id) {
                        inclusive = true
                    }
                }
            })
        }
        composable("home") {
            Home()
        }
    }
}