package com.antonioleiva.composetraining.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.compose.content
import com.antonioleiva.composetraining.ui.screens.login.LoginForm
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme


class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = content {
        ComposeTrainingTheme {
            LoginForm(onSubmit = { _, _ -> })
        }
    }
}