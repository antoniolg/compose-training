package com.antonioleiva.composetraining.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.antonioleiva.composetraining.ui.screens.detail.Detail
import com.antonioleiva.composetraining.ui.screens.detail.DetailViewModel
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
            Home(onItemClick = {
                navController.navigate("detail/${it.id}")
            })
        }
        composable(
            route = "detail/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) {
            val itemId = it.arguments?.getInt("itemId") ?: 0
            val vm = viewModel { DetailViewModel(itemId) }

            Detail(
                viewModel = vm,
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}