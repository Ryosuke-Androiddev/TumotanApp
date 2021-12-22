package com.example.tumotanapp.feature.data.data_source.remote.dto


import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.google.gson.annotations.SerializedName

data class RoomDetailDto(
    @SerializedName("room")
    val room: RemoteRoomDto,
    @SerializedName("roomLevelList")
    val roomLevelList: List<RoomLevelDto>
){
    fun toRoomWithLevel(): RoomDetail {
        return RoomDetail(
            room.roomId,
            room.roomName,
            roomLevelList.map { it.roomLevelId }
        )
    }
}