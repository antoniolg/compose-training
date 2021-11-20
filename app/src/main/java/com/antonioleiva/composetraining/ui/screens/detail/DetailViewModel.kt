package com.antonioleiva.composetraining.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.antonioleiva.composetraining.model.Item
import com.antonioleiva.composetraining.model.itemList
import com.antonioleiva.composetraining.ui.screens.NavArgs

class DetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val itemId: Int = savedStateHandle[NavArgs.ItemId.key] ?: -1

    var state by mutableStateOf<Item?>(null)
        private set

    init {
        state = itemList.find { it.id == itemId }
    }
}