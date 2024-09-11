package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ItemDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onAction: (Action) -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text(text = "Clone") },
            onClick = {
                onAction(Action.CLONE)
                onDismissRequest()
            }
        )
        DropdownMenuItem(
            text = { Text(text = "Delete") },
            onClick = {
                onAction(Action.DELETE)
                onDismissRequest()
            }
        )
    }
}