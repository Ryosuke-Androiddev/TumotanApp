package com.example.tumotanapp.feature.domain.repository

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity
import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.domain.model.Word
import kotlinx.coroutines.flow.Flow
import com.example.tumotanapp.util.Result

interface TumotanRepository {

    //Remote

    fun getAllRoom(): Flow<Result<List<Room>>>

    // TumotanApi responses RoomDto, then it has List of Word so, you can create new list when you call map defined RoomDto
    // APIは、RoomDtoを返すがその中の，List<Word>を，data class Word に変換して，List<Word>を直接得られるようにする．
    fun getWordListById(roomId: Int, roomLevelId: Int): Flow<Result<List<Word>>>

    fun getRoomDetail(roomId: Int): Flow<Result<List<RoomDetail>>>

    //Local

    //Accepted Word

    fun getAllAcceptedWord(): Flow<Result<List<AcceptedWordEntity>>>

    suspend fun insertAcceptedWord(word: AcceptedWordEntity)

    suspend fun deleteAcceptedWord(word: AcceptedWordEntity)

    fun getAcceptedWordById(roomLevelId: Int): Flow<Result<List<AcceptedWordEntity>>>

    //Rejected Word

    fun getAllRejectedWord(): Flow<Result<List<RejectedWordEntity>>>

    suspend fun insertRejectedWord(word: RejectedWordEntity)

    suspend fun deleteRejectedWord(word: RejectedWordEntity)

}