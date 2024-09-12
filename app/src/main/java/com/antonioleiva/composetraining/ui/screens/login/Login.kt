package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme
import kotlinx.serialization.Serializable

@Serializable
object Login

@Composable
fun Login(viewModel: LoginViewModel = viewModel(), onLoggedIn: () -> Unit) {

    val state = viewModel.state
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Login" }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
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
}

@Composable
fun LoginForm(
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
        AnimatedVisibility(isLoginEnabled) {
            StyledButton(
                onClick = { onSubmit(user, pass) },
                enabled = isLoginEnabled
            ) {
                Text("Login")
            }
        }

        AnimatedVisibility(message != null) {
            requireNotNull(message)
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