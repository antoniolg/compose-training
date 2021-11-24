package com.antonioleiva.composetraining

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.home.Action
import com.antonioleiva.composetraining.ui.screens.home.HomeList
import com.antonioleiva.composetraining.ui.screens.home.ITEM_DROPDOWN_TEST_TAG
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalMaterialApi
class HomeListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private var action: Action? = null
    private var index: Int = -1

    @Before
    fun setUp() {
        action = null
        index = -1
        composeTestRule.setContent {
            HomeList(items = itemList, onItemClick = {}, onAction = { a, i ->
                action = a
                index = i
            })
        }
    }

    @Test
    fun navigatesTo100AndShowsDropdown(): Unit = with(composeTestRule) {

        showPos100ActionsDropdown()

        onNodeWithTag(ITEM_DROPDOWN_TEST_TAG).assertExists()
    }

    @Test
    fun clickOnDeleteCallsLambda(): Unit = with(composeTestRule) {

        showPos100ActionsDropdown()

        onNode(
            hasParent(hasTestTag(ITEM_DROPDOWN_TEST_TAG)) and
                    hasText(ctx.getString(R.string.delete))
        ).performClick()

        Assert.assertEquals(Action.DELETE, action)
        Assert.assertEquals(100, index)
    }

    private fun ComposeContentTestRule.showPos100ActionsDropdown() {
        val pos100 = itemList[100]

        onNode(hasScrollToIndexAction())
            .performScrollToIndex(100)

        onNodeWithText(pos100.title, true)

        onNode(
            hasParent(hasText(pos100.title, true)) and
                    hasContentDescription(R.string.more_actions)
        ).performClick()
    }
}