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
import com.antonioleiva.composetraining.data.Item
import com.antonioleiva.composetraining.data.itemList

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(viewModel.state, viewModel::onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(items: List<Item>, onAction: (Action, Int) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(R.string.app_name)) }) }
    ) { innerPadding ->
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