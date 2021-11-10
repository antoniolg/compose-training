package com.antonioleiva.composetraining.ui.screens.login

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.antonioleiva.composetraining.ui.screens.Screen

@Composable
fun Login() {
    Screen {
        MyButton(text = "Hello World")
    }
}

@Composable
fun MyButton(text: String) {
    val context = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show() }) {
        Text(text = text)
    }
}