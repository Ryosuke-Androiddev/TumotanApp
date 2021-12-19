package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.Room
import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("roomId")
    val roomId: Int,
    @SerializedName("roomName")
    val roomName: String
){

    fun toRoom(): Room {
        return Room(
            roomId = roomId,
            roomName = roomName
        )
    }
}