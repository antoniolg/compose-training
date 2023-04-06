package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Screen {
        HomeGrid(viewModel)
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}