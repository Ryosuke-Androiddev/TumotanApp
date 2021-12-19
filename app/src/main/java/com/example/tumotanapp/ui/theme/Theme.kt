package com.example.tumotanapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val LightColorPalette = darkColors(
    primary = TextBlack,
    background = BackgroundWhite,
    onBackground = OnBackground,
)


@Composable
fun TumotanAppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}