package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
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