package com.example.tumotanapp.feature.presentation.detail

import com.example.tumotanapp.feature.domain.model.RoomDetail

data class DetailState(
    val room: List<RoomDetail> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
