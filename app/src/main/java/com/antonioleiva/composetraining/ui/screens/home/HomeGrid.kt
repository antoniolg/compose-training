package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antonioleiva.composetraining.model.Item

@Composable
fun HomeGrid(
    items: List<Item>,
    onAction: (Action, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = modifier.fillMaxSize(),
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