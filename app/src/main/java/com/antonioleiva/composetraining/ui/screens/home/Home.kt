package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    HomeList(items, onAction)
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    Screen {
        Home(
            items = itemList,
            onAction = { _, _ -> }
        )
    }
}