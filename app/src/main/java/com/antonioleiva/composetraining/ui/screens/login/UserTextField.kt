package com.antonioleiva.composetraining.ui.screens.login

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.antonioleiva.composetraining.R

@Composable
fun UserTextField(
    user: String,
    setUser: (String) -> Unit,
    isError: Boolean = false,
    focusRequester: FocusRequester = remember { FocusRequester() }
) {
    BgTextField(
        value = user,
        onValueChange = setUser,
        singleLine = true,
        label = { Text(stringResource(id = R.string.user)) },
        placeholder = { Text(stringResource(id = R.string.user_placeholder)) },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions { focusRequester.requestFocus() }
    )
}