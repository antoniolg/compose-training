package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Home() {
    Screen {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(itemList) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = it.title)
                    Text(text = it.subtitle)
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