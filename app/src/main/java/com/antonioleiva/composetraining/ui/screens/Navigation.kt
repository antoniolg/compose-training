package com.antonioleiva.composetraining.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.antonioleiva.composetraining.ui.screens.detail.Detail
import com.antonioleiva.composetraining.ui.screens.detail.DetailViewModel
import com.antonioleiva.composetraining.ui.screens.home.Home
import com.antonioleiva.composetraining.ui.screens.login.Login

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Login> { backStackEntry ->
            Login(onLoggedIn = {
                navController.navigate(Home) {
                    popUpTo(backStackEntry.destination.id) {
                        inclusive = true
                    }
                }
            })
        }
        composable<Home> {
            Home(onItemClick = {
                navController.navigate(Detail(it.id))
            })
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            val vm = viewModel { DetailViewModel(detail.id) }

            Detail(
                viewModel = vm,
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}