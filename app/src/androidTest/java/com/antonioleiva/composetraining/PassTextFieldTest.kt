package com.antonioleiva.composetraining

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import com.antonioleiva.composetraining.ui.screens.login.PassTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PassTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        composeTestRule.setContent {
            val (state, setState) = remember { mutableStateOf("") }
            PassTextField(pass = state, setPass = setState)
        }
    }

    @Test
    fun revealIconShowsPassword(): Unit = with(composeTestRule) {

        onNodeWithText("").performTextInput("pass")
        onNodeWithText("••••").assertExists()

        onNodeWithContentDescription(ctx.getString(R.string.reveal_password)).performClick()

        onNodeWithText("pass").assertExists()
        onNodeWithContentDescription(ctx.getString(R.string.hide_password)).assertExists()

    }
}