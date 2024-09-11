package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeList(viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(viewModel.state) { index, item ->
            if(index == 0) {
                HorizontalDivider()
            }
            HomeListItem(
                item = item,
                onAction = { viewModel.onAction(it, index) }
            )
        }
    }
}