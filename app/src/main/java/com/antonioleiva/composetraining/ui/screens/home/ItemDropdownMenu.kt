package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.antonioleiva.composetraining.R

const val ITEM_DROPDOWN_TEST_TAG = "ItemDropdownTestTag"

@Composable
fun ItemDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onAction: (Action) -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = Modifier.testTag(ITEM_DROPDOWN_TEST_TAG)
    ) {
        DropdownMenuItem(
            text = { Text(text = stringResource(R.string.clone)) },
            onClick = {
                onAction(Action.CLONE)
                onDismissRequest()
            }
        )
        DropdownMenuItem(
            text = { Text(text = stringResource(R.string.delete)) },
            onClick = {
                onAction(Action.DELETE)
                onDismissRequest()
            }
        )
    }
}