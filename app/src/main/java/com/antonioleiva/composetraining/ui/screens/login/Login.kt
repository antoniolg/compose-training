package com.antonioleiva.composetraining.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun Login(modifier: Modifier = Modifier) {
    MyButton(
        text = "Hello World",
        modifier = modifier
    )
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = { Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show() },
        modifier = modifier
    ) {
        Text(text = text)
    }
}