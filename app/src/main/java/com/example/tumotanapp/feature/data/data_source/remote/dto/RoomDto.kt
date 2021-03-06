package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class RoomDto(
    @SerializedName("roomId")
    val roomId: Int,
    @SerializedName("roomName")
    val roomName: String,
    @SerializedName("wordLevelDto")
    val roomWithLevelDto: WordWithLevelDto
)