package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.antonioleiva.composetraining.model.itemList

class HomeViewModel : ViewModel() {
    var state by mutableStateOf(itemList)
        private set

    fun onAction(action: Action, index: Int) {
        state = state.toMutableList().apply {
            when (action) {
                Action.CLONE -> add(index, get(index))
                Action.DELETE -> removeAt(index)
            }
        }
    }
}