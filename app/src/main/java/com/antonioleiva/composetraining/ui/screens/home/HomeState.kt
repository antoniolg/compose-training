package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun rememberHomeState(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    gridMode: MutableState<Boolean> = remember { mutableStateOf(false) }
) = remember { HomeState(snackbarHostState, gridMode) }

class HomeState(
    val snackbarHostState: SnackbarHostState,
    val gridMode: MutableState<Boolean>
)