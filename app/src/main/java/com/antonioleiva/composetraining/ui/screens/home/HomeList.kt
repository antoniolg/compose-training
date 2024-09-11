package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.antonioleiva.composetraining.data.Item

@Composable
fun HomeList(items: List<Item>, onAction: (Action, Int) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(items) { index, item ->
            if (index == 0) {
                HorizontalDivider()
            }
            HomeListItem(
                item = item,
                onAction = { onAction(it, index) }
            )
        }
    }
}