package com.antonioleiva.composetraining.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.antonioleiva.composetraining.ui.screens.detail.Detail
import com.antonioleiva.composetraining.ui.screens.home.Home
import com.antonioleiva.composetraining.ui.screens.login.Login

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Detail : Screen("detail/{${NavArgs.ItemId.key}}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}

enum class NavArgs(val key: String) {
    ItemId("itemId")
}

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {

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
                Home(onItemClick = {
                    navController.navigate(Screen.Detail.createRoute(it.id))
                })
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument(NavArgs.ItemId.key) { type = NavType.IntType })
            ) {
                Detail(onBackPressed = { navController.popBackStack() })
            }
        }
    }
}