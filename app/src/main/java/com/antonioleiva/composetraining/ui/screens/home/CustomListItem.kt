package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.antonioleiva.composetraining.model.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomListItem(item: Item, onAction: (Action) -> Unit) {
    var showMenu by remember { mutableStateOf(false) }

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
        },
        trailingContent = {
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Actions"
                )
            }
            ItemDropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                onAction = onAction
            )
        }
    )
}