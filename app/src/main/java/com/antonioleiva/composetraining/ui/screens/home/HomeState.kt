package com.antonioleiva.composetraining.ui.screens.home

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*

@Composable
fun rememberHomeState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    gridMode: MutableState<Boolean> = remember { mutableStateOf(false) }
) = remember { HomeState(scaffoldState, gridMode) }

class HomeState(
    val scaffoldState: ScaffoldState,
    val gridMode: MutableState<Boolean>
)