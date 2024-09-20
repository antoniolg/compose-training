package com.antonioleiva.composetraining.ui

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.antonioleiva.composetraining.R
import com.antonioleiva.composetraining.ui.screens.login.Login
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme


class MyFragment : Fragment(R.layout.fragment_my) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeView = view.findViewById<ComposeView>(R.id.composeView)
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        composeView.setContent {
            ComposeTrainingTheme {
                Login(onLoggedIn = {})
            }
        }
    }
}