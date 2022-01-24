package com.example.tumotanapp.feature.domain.use_case.rejected

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.domain.repository.TumotanRepository

class DeleteRejectedWord(
    private val repository: TumotanRepository
) {

    suspend operator fun invoke(word: AcceptedWordEntity){

        repository.deleteAcceptedWord(word)
    }
}