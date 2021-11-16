package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.Screen

@ExperimentalMaterialApi
@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(itemList) { index, item ->
            ListItem(
                text = { Text(item.title) },
                secondaryText = { Text(item.subtitle) },
                icon = {
                    Image(
                        painter = rememberImagePainter(
                            data = item.thumb,
                            builder = {
                                transformations(CircleCropTransformation())
                                crossfade(true)
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
            if (index < itemList.size - 1) {
                Divider()
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    Screen {
        Home()
    }
}