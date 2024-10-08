package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewList
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.compose.AndroidFragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.data.Item
import com.antonioleiva.composetraining.data.itemList
import com.antonioleiva.composetraining.ui.MyFragment
import kotlinx.serialization.Serializable

@Serializable
object Home

@Composable
fun Home(viewModel: HomeViewModel = viewModel(), onItemClick: (Item) -> Unit) {
    Home(
        state = viewModel.state,
        onAction = viewModel::onAction,
        onMessageRemoved = viewModel::onMessageRemoved,
        onItemClick = onItemClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    state: HomeViewModel.UiState,
    onAction: (Action, Int) -> Unit,
    onMessageRemoved: () -> Unit,
    onItemClick: (Item) -> Unit
) {
    var gridMode by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.message) {
        state.message?.let {
            snackbarHostState.showSnackbar(it)
            onMessageRemoved()
        }
    }

    Scaffold(
        modifier = Modifier.semantics { contentDescription = "Home" },
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = { gridMode = !gridMode }) {
                        Crossfade(targetState = gridMode, label = "iconCrossfade") { state ->
                            if (state) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ViewList,
                                    contentDescription = stringResource(R.string.change_view)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.GridView,
                                    contentDescription = stringResource(R.string.change_view)
                                )
                            }
                        }
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Crossfade(targetState = gridMode, label = "panelCrossfade") { gridMode ->

            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                AndroidFragment<MyFragment>()

                if (gridMode) {
                    HomeGrid(
                        items = state.items,
                        onItemClick = onItemClick,
                        onAction = onAction,
                    )
                } else {
                    HomeList(
                        items = state.items,
                        onItemClick = onItemClick,
                        onAction = onAction
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home(
        state = HomeViewModel.UiState(itemList),
        onAction = { _, _ -> },
        onMessageRemoved = {},
        onItemClick = {}
    )
}