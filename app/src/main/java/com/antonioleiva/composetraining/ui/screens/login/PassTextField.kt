package com.antonioleiva.composetraining.ui.screens.login

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.antonioleiva.composetraining.R

@Composable
fun PassTextField(
    pass: String,
    setPass: (String) -> Unit,
    isError: Boolean = false,
    onDone: () -> Unit = {}
) {
    val (passRevealed, setPassRevealed) = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = pass,
        onValueChange = setPass,
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