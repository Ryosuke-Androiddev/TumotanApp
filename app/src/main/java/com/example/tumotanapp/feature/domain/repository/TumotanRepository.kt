package com.example.tumotanapp.feature.domain.repository

import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.domain.model.Word
import kotlinx.coroutines.flow.Flow
import com.example.tumotanapp.util.Result

interface TumotanRepository {

    fun getAllRoom(): Flow<Result<List<Room>>>

    // TumotanApi responses RoomDto, then it has List of Word so, you can create new list when you call map defined RoomDto
    // APIは、RoomDtoを返すがその中の，List<Word>を，data class Word に変換して，List<Word>を直接得られるようにする．
    fun getRoomById(roomId: Int, roomLevelId: Int): Flow<Result<List<Word>>>

    fun getRoomDetail(roomId: Int): Flow<Result<List<RoomDetail>>>

}