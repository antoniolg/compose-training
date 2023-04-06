package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    Screen {
        HomeList(items, onAction)
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