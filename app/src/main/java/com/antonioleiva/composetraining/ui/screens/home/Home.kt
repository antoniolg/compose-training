package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.ui.screens.Screen

@ExperimentalMaterialApi
@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(viewModel.state) { index, item ->
            CustomListItem(
                item = item,
                onAction = { viewModel.onAction(it, index) }
            )
            if (index < viewModel.state.size - 1) {
                Divider()
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    Screen {
        Home()
    }
}