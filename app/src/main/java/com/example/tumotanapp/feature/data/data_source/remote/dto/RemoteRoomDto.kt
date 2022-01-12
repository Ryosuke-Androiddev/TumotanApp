package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.Room
import com.google.gson.annotations.SerializedName

data class RemoteRoomDto(
    @SerializedName("roomId")
    val roomId: Int,
    @SerializedName("roomName")
    val roomName: String,
    @SerializedName("roomImage")
    val roomImage: String
){

    fun toRoom(): Room {
        return Room(
            roomId = roomId,
            roomName = roomName,
            roomImage = roomImage
        )
    }
}