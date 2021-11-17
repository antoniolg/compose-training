package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.antonioleiva.composetraining.R

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
            Text(text = stringResource(R.string.clone))
        }
        DropdownMenuItem(onClick = {
            onAction(Action.DELETE)
            onDismissRequest()
        }) {
            Text(
                text = stringResource(R.string.delete),
                color = MaterialTheme.colors.error
            )
        }
    }
}