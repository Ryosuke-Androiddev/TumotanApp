package com.example.tumotanapp.feature.domain.use_case.accepted

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.feature.domain.use_case.model.UseCase
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAcceptedListById @Inject constructor(
    private val repository: TumotanRepository
) {

    operator fun invoke(roomLevelId: Int): Flow<Result<List<AcceptedWordEntity>>> {

        return repository.getAcceptedWordById(roomLevelId)
    }

}