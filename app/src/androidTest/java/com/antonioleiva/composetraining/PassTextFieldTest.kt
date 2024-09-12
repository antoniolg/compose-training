package com.antonioleiva.composetraining

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import com.antonioleiva.composetraining.ui.screens.login.PASS_REVEAL_ICON_TEST_TAG
import com.antonioleiva.composetraining.ui.screens.login.PASS_TEXT_FIELD_TEST_TAG
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

        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).performTextInput("pass")
        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).assertTextContains("••••")

        onNodeWithTag(PASS_REVEAL_ICON_TEST_TAG).performClick()

        onNodeWithTag(PASS_TEXT_FIELD_TEST_TAG).assertTextContains("pass")
        onNodeWithTag(PASS_REVEAL_ICON_TEST_TAG)
            .assertContentDescriptionEquals(ctx.getString(R.string.hide_password))

    }
}