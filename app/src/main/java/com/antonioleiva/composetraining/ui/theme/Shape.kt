package com.antonioleiva.composetraining.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp),
    medium = CutCornerShape(16.dp),
    large = CutCornerShape(32.dp)
)