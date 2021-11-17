package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

enum class Action {
    CLONE, DELETE
}

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
        DropdownMenuItem(onClick = {
            onAction(Action.CLONE)
            onDismissRequest()
        }) {
            Text(text = "Clone")
        }
        DropdownMenuItem(onClick = {
            onAction(Action.DELETE)
            onDismissRequest()
        }) {
            Text(
                text = "Delete",
                color = MaterialTheme.colors.error
            )
        }
    }
}