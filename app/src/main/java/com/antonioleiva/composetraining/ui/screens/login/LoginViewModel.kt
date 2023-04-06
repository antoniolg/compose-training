package com.antonioleiva.composetraining.ui.screens.login

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.antonioleiva.composetraining.R

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(UiState())

    data class UiState(
        val loggedIn: Boolean = false,
        @StringRes val error: Int? = null
    )

    fun loginClicked(user: String, pass: String) {
        state = when {
            !user.contains('@') -> UiState(error = R.string.wrong_username)
            pass.length < 5 -> UiState(error = R.string.short_password)
            else -> UiState(loggedIn = true)
        }
    }
}