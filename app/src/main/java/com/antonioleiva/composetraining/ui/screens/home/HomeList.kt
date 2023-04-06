package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.antonioleiva.composetraining.model.Item

@Composable
fun HomeList(
    items: List<Item>,
    onItemClick: (Item) -> Unit,
    onAction: (Action, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(items) { index, item ->
            HomeListItem(
                item = item,
                onAction = { onAction(it, index) },
                modifier = Modifier.clickable { onItemClick(item) }
            )
            if (index < items.size - 1) {
                Divider()
            }
        }
    }
}