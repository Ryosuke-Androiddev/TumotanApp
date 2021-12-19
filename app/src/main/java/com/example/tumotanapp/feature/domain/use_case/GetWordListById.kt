package com.example.tumotanapp.feature.domain.use_case

import com.example.tumotanapp.feature.domain.model.Word
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordListById @Inject constructor(
    private val repository: TumotanRepository
) {

    operator fun invoke(roomId: Int, roomWithLevelId: Int): Flow<Result<List<Word>>> {

        return repository.getRoomById(roomId,roomWithLevelId)
    }
}