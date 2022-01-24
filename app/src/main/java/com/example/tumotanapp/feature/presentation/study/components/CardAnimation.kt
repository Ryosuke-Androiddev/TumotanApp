package com.example.tumotanapp.feature.presentation.study.components

import androidx.compose.runtime.Composable

sealed class SwipeState(){

    object Initial: SwipeState()
    object Swiped: SwipeState()
}

