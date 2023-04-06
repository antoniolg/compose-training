package com.antonioleiva.composetraining

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.antonioleiva.composetraining.ui.screens.Screen
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen {
                MyButton(text = "Hello World")
            }
        }
    }
}

@Composable
fun MyButton(text: String) {
    val context = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show() }) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTrainingTheme {
        Greeting("Android")
    }
}