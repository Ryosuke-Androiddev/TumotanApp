package com.example.tumotanapp.feature.domain.use_case.remote

import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRoom @Inject constructor(
    private val repository: TumotanRepository
) {

    operator fun invoke(): Flow<Result<List<Room>>> {

        return repository.getAllRoom()
    }
}