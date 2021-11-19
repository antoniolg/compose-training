package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.model.Item

@ExperimentalMaterialApi
@Composable
fun HomeListItem(item: Item, onAction: (Action) -> Unit, modifier: Modifier = Modifier) {
    var showMenu by remember { mutableStateOf(false) }

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
        },
        trailing = {
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.more_actions)
                )
            }
            ItemDropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                onAction = onAction
            )
        },
        modifier = modifier
    )
}