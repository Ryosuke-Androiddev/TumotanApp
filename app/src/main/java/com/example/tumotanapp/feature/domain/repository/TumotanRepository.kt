package com.example.tumotanapp.feature.domain.repository

import com.example.tumotanapp.feature.domain.model.Room
import kotlinx.coroutines.flow.Flow
import com.example.tumotanapp.util.Result

interface TumotanRepository {

    fun getAllRoom(): Flow<Result<List<Room>>>

    suspend fun getRoomById(roomId: Int, roomLevel: Int): Room

    fun getRoomWithLevel(roomId: Int): Flow<Result<List<Room>>>
}