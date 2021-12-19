package com.example.tumotanapp.feature.presentation.study

import com.example.tumotanapp.feature.domain.model.Word

data class WordState(
    val word: List<Word> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
