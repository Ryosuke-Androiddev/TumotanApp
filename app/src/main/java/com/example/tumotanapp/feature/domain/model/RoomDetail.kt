package com.example.tumotanapp.feature.domain.model

data class RoomDetail(
    val roomId: Int,
    val roomName: String,
    val roomImage: String,
    val roomLevelId: List<Int>
)