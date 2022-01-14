package com.example.tumotanapp.feature.domain.use_case.accepted

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWord
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import kotlinx.coroutines.flow.Flow

class GetAllAcceptedList(
    private val repository: TumotanRepository
) {

    operator fun invoke(): Flow<List<AcceptedWord>> {

        return repository.getAllAcceptedWord()
    }
}