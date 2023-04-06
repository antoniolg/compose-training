package com.antonioleiva.composetraining.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Detail(viewModel: DetailViewModel = viewModel(), onBackPressed: () -> Unit) {
    Detail(viewModel.state, onBackPressed)
}

@Composable
fun Detail(item: Item?, onBackPressed: () -> Unit) {
    if (item == null) return

    Column {
        Box {
            AsyncImage(
                model = item.thumb,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
            )
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp, 8.dp)
        )
        Text(
            text = item.subtitle,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp, 8.dp)
        )
    }
}

@Preview
@Composable
fun DetailPreview() {
    val item = Item(1, "Title 1", "Subtitle 1", " ")
    Screen {
        Detail(item = item, onBackPressed = {})
    }
}