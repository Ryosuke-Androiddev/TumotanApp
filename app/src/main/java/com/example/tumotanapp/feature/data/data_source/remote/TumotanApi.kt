package com.example.tumotanapp.feature.data.data_source.remote

import com.example.tumotanapp.feature.data.data_source.remote.dto.RemoteRoomDto
import com.example.tumotanapp.feature.data.data_source.remote.dto.RoomDto
import com.example.tumotanapp.feature.data.data_source.remote.dto.RoomDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TumotanApi {

    @GET("/room")
    suspend fun getAllRoom(): List<RemoteRoomDto>

    @GET("/room/{roomId}/{roomLevel}")
    suspend fun getRoomById(@Path("roomId") roomId: Int, @Path("roomLevel") roomLevel: Int): RoomDto

    //Json response is List<RoomDetailDto>, must be this style here
    @GET("/room/{roomId}")
    suspend fun getRoomDetail(@Path("roomId") roomId: Int): List<RoomDetailDto>

}