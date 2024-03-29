package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Login(viewModel: LoginViewModel = viewModel(), onLoggedIn: () -> Unit) {
    val state = viewModel.state
    Screen {
        LaunchedEffect(state.loggedIn) {
            if (state.loggedIn) {
                onLoggedIn()
            }
        }

        LoginForm(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
                .padding(16.dp),
            message = state.error?.let { stringResource(it) },
            onSubmit = viewModel::loginClicked
        )
    }
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    message: String? = null,
    onSubmit: (user: String, pass: String) -> Unit
) {
    var user by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    val buttonEnabled = user.isNotEmpty() && pass.isNotEmpty()
    val isError = message != null

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .width(IntrinsicSize.Min)
            .semantics { contentDescription = "Login" }
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
            onDone = { if (buttonEnabled) onSubmit(user, pass) }
        )
        AnimatedVisibility(buttonEnabled) {
            Button(
                onClick = { onSubmit(user, pass) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(id = R.string.login))
            }
        }

        AnimatedVisibility(message != null) {
            if (message != null) {
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview("Login Light")
@Preview("Login Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginPreview() {
    Screen {
        LoginForm(message = "This is message", onSubmit = { _, _ -> })
    }
}