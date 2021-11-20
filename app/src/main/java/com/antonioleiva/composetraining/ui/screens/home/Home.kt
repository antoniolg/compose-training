package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Home(onItemClick: (Item) -> Unit, viewModel: HomeViewModel = viewModel()) {
    Home(
        state = viewModel.state,
        onAction = viewModel::onAction,
        onMessageRemoved = viewModel::onMessageRemoved,
        onItemClick = onItemClick
    )
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Home(
    state: HomeViewModel.UiState,
    onAction: (Action, Int) -> Unit,
    onMessageRemoved: () -> Unit,
    onItemClick: (Item) -> Unit
) {
    var gridMode by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    if (state.message != null) {
        LaunchedEffect(state.message) {
            scaffoldState
                .snackbarHostState
                .showSnackbar(state.message)
            onMessageRemoved()
        }
    }

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
        },
        scaffoldState = scaffoldState
    ) { padding ->
        if (gridMode) {
            HomeGrid(
                items = state.items,
                onItemClick = onItemClick,
                onAction = onAction,
                modifier = Modifier.padding(padding)
            )
        } else {
            HomeList(
                items = state.items,
                onItemClick = onItemClick,
                onAction = onAction,
                modifier = Modifier.padding(padding)
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    Screen {
        Home(
            state = HomeViewModel.UiState(itemList),
            onAction = { _, _ -> },
            onMessageRemoved = {},
            onItemClick = {}
        )
    }
}