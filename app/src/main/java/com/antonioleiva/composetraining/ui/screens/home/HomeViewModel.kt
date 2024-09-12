package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.antonioleiva.composetraining.data.Item
import com.antonioleiva.composetraining.data.itemList

class HomeViewModel : ViewModel() {
    var state by mutableStateOf(UiState(itemList))
        private set

    fun onAction(action: Action, index: Int) {
        val newItems = state.items.toMutableList()
        val item = state.items[index]
        state = when (action) {
            Action.CLONE -> UiState(
                items = newItems.apply { add(index, get(index)) },
                message = "${item.title} cloned"
            )

            Action.DELETE -> UiState(
                items = newItems.apply { removeAt(index) },
                message = "${item.title} removed"
            )
        }
    }

    fun onMessageRemoved() {
        state = state.copy(message = null)
    }

    data class UiState(
        val items: List<Item> = emptyList(),
        val message: String? = null
    )
}