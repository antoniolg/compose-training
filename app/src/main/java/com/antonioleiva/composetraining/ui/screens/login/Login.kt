package com.antonioleiva.composetraining.ui.screens.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.composetraining.ui.screens.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    Screen {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(value = "user", onValueChange = {})
            TextField(value = "password", onValueChange = {})
            Button(onClick = { }) {
                Text("Login")
            }
        }
    }
}

@Preview("Login Light")
@Preview("Login Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginPreview() {
    Login()
}