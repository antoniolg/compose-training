package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Login(viewModel: LoginViewModel = viewModel()) {
    val state = viewModel.state
    Screen {
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
fun LoginForm(
    modifier: Modifier = Modifier,
    message: String? = null,
    onSubmit: (user: String, pass: String) -> Unit
) {
    var user by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    val buttonEnabled = user.isNotEmpty() && pass.isNotEmpty()
    val focusRequester = remember { FocusRequester() }
    val isError = message != null

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .width(IntrinsicSize.Min)
    ) {
        UserTextField(
            user = user,
            setUser = { user = it },
            isError = isError,
            focusRequester = focusRequester
        )
        PassTextField(
            pass = pass,
            setPass = { pass = it },
            isError = isError,
            focusRequester = focusRequester,
            onDone = { if (buttonEnabled) onSubmit(user, pass) }
        )
        Button(
            enabled = buttonEnabled,
            onClick = { onSubmit(user, pass) },
            modifier = Modifier.fillMaxWidth()
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
    Screen {
        LoginForm(message = "This is message", onSubmit = { _, _ -> })
    }
}