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
fun TumotanTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = kotlin.text.Typography,
        shapes = Shapes,
        content = content
    )
}