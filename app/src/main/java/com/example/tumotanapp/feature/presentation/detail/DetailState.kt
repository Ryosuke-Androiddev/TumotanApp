package com.example.tumotanapp.feature.presentation.detail

import com.example.tumotanapp.feature.domain.model.RoomWithLevel

data class DetailState(
    val room: List<RoomWithLevel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
