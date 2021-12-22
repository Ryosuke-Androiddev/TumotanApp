package com.example.tumotanapp.feature.domain.use_case.unite

import com.example.tumotanapp.feature.domain.use_case.GetAllRoom
import com.example.tumotanapp.feature.domain.use_case.GetRoomDetail

data class UseCase(
    val getAllRoom: GetAllRoom,
    val getRoomWithRevel: GetRoomDetail
)
