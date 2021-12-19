package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class RoomWithLevelDto(
    @SerializedName("roomLevel")
    val roomLevel: Int,
    @SerializedName("wordList")
    val wordList: List<WordDto>
)