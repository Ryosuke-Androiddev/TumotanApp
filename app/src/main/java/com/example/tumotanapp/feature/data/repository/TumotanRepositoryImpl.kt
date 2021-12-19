package com.example.tumotanapp.feature.data.repository

import com.example.tumotanapp.feature.data.data_source.remote.TumotanApi
import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.model.RoomWithLevel
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class TumotanRepositoryImpl(
    private val api: TumotanApi
): TumotanRepository {
    override fun getAllRoom(): Flow<Result<List<Room>>> = flow<Result<List<Room>>> {

        emit(Result.Loading())

        try {

            val roomList = api.getAllRoom().map { it.toRoom() }
            emit(Result.Success(roomList))

        } catch (e: HttpException){

            emit(Result.Error(
                message = "Something went wrong!"
            ))

        } catch (e: IOException){

            emit(Result.Error(
                message = "Couldn't reach server"
            ))

        }
    }

    override suspend fun getRoomById(roomId: Int, roomLevel: Int): Flow<Result<Room>> = flow<Result<Room>> {
        emit(Result.Loading())

        try {

            val roomList = api.getRoomById(roomId, roomLevel)

        } catch (e: HttpException){

            emit(Result.Error(
                message = "Something went wrong!"
            ))

        } catch (e: IOException){

            emit(Result.Error(
                message = "Couldn't reach server"
            ))

        }
    }

    override fun getRoomWithLevel(roomId: Int): Flow<Result<List<RoomWithLevel>>> = flow<Result<List<RoomWithLevel>>> {

        emit(Result.Loading())

        try {

            val roomList = api.getRoomWitheRevel(roomId).map { it.toRoomWithLevel() }
            emit(Result.Success(roomList))

        } catch (e: HttpException){

            emit(Result.Error(
                message = "Something went wrong!"
            ))

        } catch (e: IOException){

            emit(Result.Error(
                message = "Couldn't reach server"
            ))

        }
    }
}