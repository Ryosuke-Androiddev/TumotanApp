package com.example.tumotanapp.feature.presentation.result

import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity


data class ResultScreenState(
    val acceptedList: List<AcceptedWordEntity> = emptyList(),
    val rejectedList: List<RejectedWordEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)