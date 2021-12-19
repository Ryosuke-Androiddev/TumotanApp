package com.example.tumotanapp.feature.presentation.home

import com.example.tumotanapp.feature.domain.model.Room

data class HomeScreenState(
    val roomList: List<Room> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
