package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme

@Composable
fun Login(modifier: Modifier = Modifier, viewModel: LoginViewModel = viewModel()) {

    val state = viewModel.state

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val message = when {
            state.loggedIn -> "Success"
            state.error != null -> stringResource(id = state.error)
            else -> null
        }

        LoginForm(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Gray.copy(alpha = 0.2f))
                .padding(16.dp),
            message = message,
            onSubmit = viewModel::loginClicked
        )
    }
}

@Composable
private fun LoginForm(
    modifier: Modifier = Modifier,
    message: String? = null,
    onSubmit: (user: String, pass: String) -> Unit
) {
    var user by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    val isLoginEnabled = user.isNotBlank() && pass.isNotBlank()
    val isError = message != null

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        UserTextField(
            user = user,
            setUser = { user = it },
            isError = isError
        )
        PassTextField(
            pass = pass,
            setPass = { pass = it },
            isError = isError,
            onDone = { if (isLoginEnabled) onSubmit(user, pass) }
        )
        Button(
            onClick = { onSubmit(user, pass) },
            enabled = isLoginEnabled
        ) {
            Text("Login")
        }

        if (message != null) {
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview("Login Light")
@Preview("Login Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginPreview() {
    ComposeTrainingTheme {
        LoginForm(message = "This is message", onSubmit = { _, _ -> })
    }
}