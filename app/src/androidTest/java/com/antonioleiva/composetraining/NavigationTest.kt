package com.antonioleiva.composetraining

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.antonioleiva.composetraining.ui.screens.Navigation
import com.antonioleiva.composetraining.ui.screens.home.Home
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: NavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = rememberNavController()
            Navigation(navController)
        }
    }

    @Test
    fun firstScreenIsLogin() {
        composeTestRule
            .onNodeWithContentDescription("Login")
            .assertIsDisplayed()
    }

    @Test
    fun navigateToHome() {
        runBlocking {
            withContext(Dispatchers.Main) {
                navController.navigate(Home)
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Home")
            .assertIsDisplayed()
    }
}