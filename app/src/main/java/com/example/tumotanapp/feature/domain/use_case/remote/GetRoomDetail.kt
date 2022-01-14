package com.example.tumotanapp.feature.domain.use_case.remote

import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoomDetail @Inject constructor(
    private val repository: TumotanRepository
) {

    operator fun invoke(roomId: Int): Flow<Result<List<RoomDetail>>> {
        return repository.getRoomDetail(roomId)
    }
}