package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.RoomWithLevel
import com.google.gson.annotations.SerializedName

data class RoomWithLevelDto(
    @SerializedName("room")
    val room: Room,
    @SerializedName("roomLevelList")
    val roomLevelList: List<RoomLevel>
){
    fun toRoomWithLevel(): RoomWithLevel {
        return RoomWithLevel(
            room.roomId,
            room.roomName,
            roomLevelList.map { it.roomLevelId }
        )
    }
}