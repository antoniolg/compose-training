package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewList
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.data.Item
import com.antonioleiva.composetraining.data.itemList

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    var gridMode by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = { gridMode = !gridMode }) {
                        Icon(
                            imageVector = if (gridMode) Icons.AutoMirrored.Default.ViewList else Icons.Default.GridView,
                            contentDescription = stringResource(R.string.change_view)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (gridMode) {
            HomeGrid(
                items = items,
                onAction = onAction,
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            HomeList(
                items = items,
                onAction = onAction,
                modifier = Modifier.padding(innerPadding)
            )
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