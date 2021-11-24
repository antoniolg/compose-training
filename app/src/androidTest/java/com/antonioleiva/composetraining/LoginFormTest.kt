package com.antonioleiva.composetraining

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.antonioleiva.composetraining.ui.screens.login.LoginForm
import com.antonioleiva.composetraining.ui.screens.login.PASS_TEXT_FIELD_TEST_TAG
import com.antonioleiva.composetraining.ui.screens.login.USER_TEXT_FIELD_TEST_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginFormTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            LoginForm(onSubmit = { _, _ -> })
        }
    }

    @Test
    fun onlyUserFilledWontShowLoginButton(): Unit = with(composeTestRule) {
        onNodeWithTag(USER_TEXT_FIELD_TEST_TAG).performTextInput("user")

        onNodeWithRes(R.string.login).assertDoesNotExist()
    }

    @Test
    fun userAndPassFilledShowLoginButton(): Unit = with(composeTestRule) {
        onNodeWithTag(USER_TEXT_FIELD_TEST_TAG).performTextInput("user")
        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).performTextInput("pass")

        onNodeWithRes(R.string.login).assertIsDisplayed()
    }
}