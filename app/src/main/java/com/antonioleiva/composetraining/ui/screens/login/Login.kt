package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme

@Composable
fun Login(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoginForm(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Gray.copy(alpha = 0.2f))
                .padding(16.dp)
        )
    }
}

@Composable
private fun LoginForm(modifier: Modifier = Modifier) {
    var user by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    val isLoginEnabled = user.isNotBlank() && pass.isNotBlank()

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Usuario") }
        )
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Contraseña") }
        )
        Button(
            onClick = {
                user = ""
                pass = ""
            },
            enabled = isLoginEnabled
        ) {
            Text("Login")
        }
    }
}

@Preview("Login Light")
@Preview("Login Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginPreview() {
    ComposeTrainingTheme {
        Login()
    }
}