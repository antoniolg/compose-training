package com.antonioleiva.composetraining.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    ComposeTrainingTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            //modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}