package com.example.tumotanapp.feature.domain.model

data class RoomWithLevel(
    val roomId: Int,
    val roomName: String,
    val roomLevelId: List<Int>
)