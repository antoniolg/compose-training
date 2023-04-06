package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    Screen {
        var gridMode by remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name)) },
                    actions = {
                        IconButton(onClick = { gridMode = !gridMode }) {
                            Icon(
                                imageVector = if (gridMode) Icons.Default.ViewList else Icons.Default.GridView,
                                contentDescription = stringResource(R.string.change_view)
                            )
                        }
                    }
                )
            }
        ) { padding ->
            if (gridMode) {
                HomeGrid(
                    items = items,
                    onAction = onAction,
                    modifier = Modifier.padding(padding)
                )
            } else {
                HomeList(
                    items = items,
                    onAction = onAction,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home(
        items = itemList,
        onAction = { _, _ -> }
    )
}