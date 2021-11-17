package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.model.Item

@Composable
fun HomeGridItem(item: Item, onAction: (Action) -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(2.dp)
    ) {
        Image(
            painter = rememberImagePainter(item.thumb),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f)
        )
        Row(
            modifier = Modifier.background(MaterialTheme.colors.surface)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            )
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.more_actions)
                )
                ItemDropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    onAction = onAction
                )
            }
        }
    }
}