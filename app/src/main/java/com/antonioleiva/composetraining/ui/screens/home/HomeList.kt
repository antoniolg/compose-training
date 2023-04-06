package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.antonioleiva.composetraining.model.Item

@Composable
fun HomeList(items: List<Item>, onAction: (Action, Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items) { index, item ->
            HomeListItem(
                item = item,
                onAction = { onAction(it, index) }
            )
            if (index < items.size - 1) {
                Divider()
            }
        }
    }
}