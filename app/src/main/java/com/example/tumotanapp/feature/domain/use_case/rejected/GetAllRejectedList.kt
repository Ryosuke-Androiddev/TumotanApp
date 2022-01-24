package com.example.tumotanapp.feature.domain.use_case.rejected

import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow

class GetAllRejectedList(
    private val repository: TumotanRepository
) {

    operator fun invoke(): Flow<Result<List<RejectedWordEntity>>> {

        return repository.getAllRejectedWord()
    }
}