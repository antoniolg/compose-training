package com.antonioleiva.composetraining.ui.screens

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.ui.screens.detail.Detail
import com.antonioleiva.composetraining.ui.screens.home.Home
import com.antonioleiva.composetraining.ui.screens.login.Login
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Detail : Screen("detail/{${NavArgs.ItemId.key}}") {
        fun createRoute(item: Item) = "detail/${Uri.encode(Json.encodeToJsonElement(item).toString())}"
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
                    navController.navigate(Screen.Detail.createRoute(it))
                })
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument(NavArgs.ItemId.key) {
                    type = parcelableType<Item>()
                })
            ) {
                Detail(onBackPressed = { navController.popBackStack() })
            }
        }
    }
}

inline fun <reified T : Parcelable> parcelableType() =
    object : NavType<T>(isNullableAllowed = false) {
        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }

        override fun get(bundle: Bundle, key: String): T? {
            return bundle.getParcelable(key)
        }

        override fun parseValue(value: String): T {
            return Json.decodeFromString(Uri.decode(value))
        }

    }
