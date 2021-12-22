package com.example.tumotanapp.feature.data.repository

import com.example.tumotanapp.feature.data.data_source.remote.TumotanApi
import com.example.tumotanapp.feature.domain.model.Room
import com.example.tumotanapp.feature.domain.model.RoomDetail
import com.example.tumotanapp.feature.domain.model.Word
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

    override fun getRoomById(roomId: Int, roomLevelId: Int): Flow<Result<List<Word>>> = flow<Result<List<Word>>> {

        emit(Result.Loading())

        try {

            val roomList = api.getRoomById(roomId, roomLevelId).toWordList()
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

    override fun getRoomDetail(roomId: Int): Flow<Result<List<RoomDetail>>> = flow<Result<List<RoomDetail>>> {

        emit(Result.Loading())

        try {

            val roomDetail = api.getRoomDetail(roomId).map { it.toRoomWithLevel() }
            emit(Result.Success(roomDetail))

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