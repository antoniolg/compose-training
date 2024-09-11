package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.antonioleiva.composetraining.data.itemList

@Composable
fun Home() {
    Scaffold { innerPadding ->
        var itemList by remember { mutableStateOf(itemList) }
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            itemsIndexed(itemList) { index, item ->
                if (index != 0) {
                    HorizontalDivider()
                }
                CustomListItem(item = item, onAction = {
                    val list = itemList.toMutableList()
                    itemList = when (it) {
                        Action.CLONE -> list.apply { add(index, item) }
                        Action.DELETE -> list.apply { removeAt(index) }
                    }
                })
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}