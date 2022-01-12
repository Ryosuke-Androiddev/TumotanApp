package com.example.tumotanapp.feature.presentation.study.components

import com.example.tumotanapp.feature.domain.model.Word

object ListProvider {

    val listProvider = mutableListOf<Word>(
        Word("apple1", "apple", "abc1",1),
        Word("apple2", "apple", "abc2",1),
        Word("apple3", "apple", "abc3",1),
    )
}