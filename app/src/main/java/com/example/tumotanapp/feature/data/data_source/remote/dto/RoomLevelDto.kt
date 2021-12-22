package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class RoomLevelDto(
    @SerializedName("roomId")
    val roomId: Int,
    @SerializedName("roomLevel")
    val roomLevel: Int,
    @SerializedName("roomLevelId")
    val roomLevelId: Int
)