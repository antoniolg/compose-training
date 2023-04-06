package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Screen {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(itemList) { index, item ->
                ListItem(
                    headlineText = { Text(item.title) },
                    supportingText = { Text(item.subtitle) },
                    leadingContent = {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.thumb)
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                        )
                    }
                )
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