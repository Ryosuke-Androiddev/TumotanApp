package com.example.tumotanapp.feature.domain.use_case

import com.example.tumotanapp.feature.domain.model.RoomWithLevel
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoomWithLevel @Inject constructor(
    private val repository: TumotanRepository
) {

    operator fun invoke(roomId: Int): Flow<Result<List<RoomWithLevel>>> {
        return repository.getRoomWithLevel(roomId)
    }
}