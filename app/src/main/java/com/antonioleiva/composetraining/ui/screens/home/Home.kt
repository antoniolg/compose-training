package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Home() {
    Screen {
        var itemList by remember { mutableStateOf(itemList) }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(itemList) { index, item ->
                CustomListItem(item = item, onAction = {
                    val list = itemList.toMutableList()
                    itemList = when (it) {
                        Action.CLONE -> list.apply { add(index, item) }
                        Action.DELETE -> list.apply { removeAt(index) }
                    }
                })
                if (index < itemList.size - 1) {
                    Divider()
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}