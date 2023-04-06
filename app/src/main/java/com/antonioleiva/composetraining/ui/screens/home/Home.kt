package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = stringResource(R.string.app_name)) }) }
        ) { padding ->
            HomeList(
                items = items,
                onAction = onAction,
                modifier = Modifier.padding(padding)
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