package com.antonioleiva.composetraining.ui.screens.login

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.antonioleiva.composetraining.R

const val USER_TEXT_FIELD_TEST_TAG = "UserTextFieldTestTag"

@Composable
fun UserTextField(
    user: String,
    setUser: (String) -> Unit,
    isError: Boolean = false
) {
    OutlinedTextField(
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
        modifier = Modifier.testTag(USER_TEXT_FIELD_TEST_TAG)
    )
}