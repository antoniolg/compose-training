package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@ExperimentalFoundationApi
@Composable
fun HomeGrid(items: List<Item>, onAction: (Action, Int) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(180.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(2.dp)
    ) {
        itemsIndexed(items) { index, item ->
            HomeGridItem(
                item = item,
                onAction = { onAction(it, index) }
            )
        }
    }
}