package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Scaffold { innerPadding ->
        HomeGrid(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}