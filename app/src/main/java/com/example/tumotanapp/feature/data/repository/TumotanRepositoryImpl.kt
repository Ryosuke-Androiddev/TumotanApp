package com.example.tumotanapp.feature.data.repository

import com.example.tumotanapp.feature.data.data_source.local.db.dao.AcceptedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.dao.RejectedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity
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
    private val api: TumotanApi,
    private val acceptedDao: AcceptedWordDao,
    private val rejectedDao: RejectedWordDao
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

    override fun getWordListById(roomId: Int, roomLevelId: Int): Flow<Result<List<Word>>> = flow<Result<List<Word>>> {

        emit(Result.Loading())

        try {

            val roomList = api.getWordListById(roomId, roomLevelId).toWordList()
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

    // Local DB

    override fun getAllAcceptedWord(): Flow<Result<List<AcceptedWordEntity>>> = flow<Result<List<AcceptedWordEntity>>> {

        emit(Result.Loading())

        try {

            val acceptedList = acceptedDao.getAllAcceptedWord()
            emit(Result.Success(acceptedList))

        } catch (e: IOException){

            emit(Result.Error(
                message = e.toString()
            ))
        }
    }

    override suspend fun insertAcceptedWord(word: AcceptedWordEntity) {

        return acceptedDao.insertAcceptedWord(word)
    }

    override suspend fun deleteAcceptedWord(word: AcceptedWordEntity) {

        return acceptedDao.deleteAcceptedWord(word)
    }

    override fun getAcceptedWordById(roomLevelId: Int): Flow<Result<List<AcceptedWordEntity>>> = flow<Result<List<AcceptedWordEntity>>> {

        emit(Result.Loading())

        try {

            val acceptedList = acceptedDao.getAcceptedWordById(roomLevelId)
            emit(Result.Success(acceptedList))

        } catch (e: IOException){

            emit(Result.Error(
                message = e.toString()
            ))
        }
    }

    override fun getAllRejectedWord(): Flow<Result<List<RejectedWordEntity>>> = flow<Result<List<RejectedWordEntity>>> {

        emit(Result.Loading())

        try {

            val rejectedList = rejectedDao.getAllRejectedWord()
            emit(Result.Success(rejectedList))

        } catch (e: IOException){

            emit(Result.Error(
                message = e.toString()
            ))
        }
    }

    override suspend fun insertRejectedWord(word: RejectedWordEntity) {

        return rejectedDao.insertRejectedWord(word)
    }

    override suspend fun deleteRejectedWord(word: RejectedWordEntity) {

        return rejectedDao.deleteRejectedWord(word)
    }
}