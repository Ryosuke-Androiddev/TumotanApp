package com.example.tumotanapp.feature.domain.repository

import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.model.RoomWithLevel
import com.example.tumotanapp.feature.domain.model.Word
import kotlinx.coroutines.flow.Flow
import com.example.tumotanapp.util.Result

interface TumotanRepository {

    fun getAllRoom(): Flow<Result<List<Room>>>

    fun getRoomById(roomId: Int, roomLevel: Int): Flow<Result<List<Word>>>

    fun getRoomWithLevel(roomId: Int): Flow<Result<List<RoomWithLevel>>>
}