package com.example.tumotanapp.feature.data.data_source.remote

import com.example.tumotanapp.feature.data.data_source.remote.dto.Room
import com.example.tumotanapp.feature.data.data_source.remote.dto.RoomDto
import com.example.tumotanapp.feature.data.data_source.remote.dto.RoomWithLevelDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TumotanApi {

    @GET("/room")
    suspend fun getAllRoom(): List<Room>

    @GET("/room/{roomId}/{roomLevel}")
    suspend fun getRoomById(@Path("roomId") roomId: Int, @Path("roomLevel") roomLevel: Int): RoomDto

    @GET("/room/{roomId}")
    suspend fun getRoomWitheRevel(@Path("roomId") roomId: Int): List<RoomWithLevelDto>

}