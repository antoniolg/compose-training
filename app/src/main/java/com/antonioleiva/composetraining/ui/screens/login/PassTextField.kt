package com.antonioleiva.composetraining.ui.screens.login

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.antonioleiva.composetraining.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassTextField(
    pass: String,
    setPass: (String) -> Unit,
    isError: Boolean = false,
    focusRequester: FocusRequester = remember { FocusRequester() },
    onDone: () -> Unit = {}
) {
    val (passRevealed, setPassRevealed) = rememberSaveable { mutableStateOf(false) }

    TextField(
        value = pass,
        onValueChange = setPass,
        modifier = Modifier.focusRequester(focusRequester),
        singleLine = true,
        label = { Text(stringResource(id = R.string.password)) },
        placeholder = { Text(stringResource(id = R.string.pass_placeholder)) },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions { onDone() },
        visualTransformation = if (passRevealed) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = { PasswordVisibilityIcon(passRevealed, setPassRevealed) }
    )
}

@Composable
private fun PasswordVisibilityIcon(passRevealed: Boolean, setPassRevealed: (Boolean) -> Unit) {
    IconButton(onClick = { setPassRevealed(!passRevealed) }) {
        if (passRevealed) {
            Icon(
                imageVector = Icons.Default.VisibilityOff,
                contentDescription = stringResource(id = R.string.hide_password)
            )
        } else {
            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = stringResource(id = R.string.reveal_password)
            )
        }
    }
}