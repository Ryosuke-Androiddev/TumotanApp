package com.example.tumotanapp.feature.domain.use_case.accepted

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWord
import com.example.tumotanapp.feature.domain.repository.TumotanRepository

class InsertAcceptedWord(
    private val repository: TumotanRepository
) {

    suspend operator fun invoke(word: AcceptedWord){

        repository.insertAcceptedWord(word)
    }
}