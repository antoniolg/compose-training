package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.data.Item
import com.antonioleiva.composetraining.data.itemList

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    Scaffold { innerPadding ->
        HomeList(
            items = items,
            onAction = onAction,
            modifier = Modifier.padding(innerPadding)
        )
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