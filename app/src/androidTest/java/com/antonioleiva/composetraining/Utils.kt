package com.antonioleiva.composetraining

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import androidx.test.platform.app.InstrumentationRegistry

val ctx: Context get() = InstrumentationRegistry.getInstrumentation().targetContext

fun SemanticsNodeInteractionsProvider.onNodeWithRes(
    @StringRes res: Int,
    substring: Boolean = false,
    ignoreCase: Boolean = false,
    useUnmergedTree: Boolean = false
): SemanticsNodeInteraction = onNodeWithText(
    ctx.getString(res),
    substring,
    ignoreCase,
    useUnmergedTree
)

fun hasContentDescription(
    @StringRes res: Int,
    substring: Boolean = false,
    ignoreCase: Boolean = false
): SemanticsMatcher = hasContentDescription(ctx.getString(res), substring, ignoreCase)