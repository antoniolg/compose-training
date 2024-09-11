package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.data.itemList

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            itemsIndexed(viewModel.state) { index, item ->
                if(index == 0) {
                    HorizontalDivider()
                }
                CustomListItem(
                    item = item,
                    onAction = { viewModel.onAction(it, index) }
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}