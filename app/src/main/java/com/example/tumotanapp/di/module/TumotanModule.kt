package com.example.tumotanapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.tumotanapp.feature.data.data_source.local.db.WordDatabase
import com.example.tumotanapp.feature.data.data_source.remote.TumotanApi
import com.example.tumotanapp.feature.data.repository.TumotanRepositoryImpl
import com.example.tumotanapp.feature.data.util.DataLayerConstants
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.feature.domain.use_case.accepted.DeleteAcceptedWord
import com.example.tumotanapp.feature.domain.use_case.accepted.GetAllAcceptedList
import com.example.tumotanapp.feature.domain.use_case.accepted.InsertAcceptedWord
import com.example.tumotanapp.feature.domain.use_case.remote.GetAllRoom
import com.example.tumotanapp.feature.domain.use_case.remote.GetRoomDetail
import com.example.tumotanapp.feature.domain.use_case.model.UseCase
import com.example.tumotanapp.feature.domain.use_case.rejected.DeleteRejectedWord
import com.example.tumotanapp.feature.domain.use_case.rejected.GetAllRejectedList
import com.example.tumotanapp.feature.domain.use_case.rejected.InsertRejectedWord
import com.example.tumotanapp.feature.domain.use_case.remote.GetWordListById
import com.example.tumotanapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TumotanModule {

    @Provides
    @Singleton
    fun provideTumotanApi(): TumotanApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TumotanApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTumotanRepository(api: TumotanApi, db: WordDatabase): TumotanRepository {
        return TumotanRepositoryImpl(api, db.acceptedWordDao(), db.rejectedWordDao())
    }

    // Local DB setup

    @Provides
    @Singleton
    fun provideWordDatabase(application: Application): WordDatabase {

        return Room.databaseBuilder(
            application,
            WordDatabase::class.java,
            DataLayerConstants.DATABASE_NAME
        ).build()
    }

    // USE CASE setup

    @Provides
    @Singleton
    fun provideUseCase(repository: TumotanRepository): UseCase{
        return UseCase(
            getAllRoom = GetAllRoom(repository),
            getRoomWithRevel = GetRoomDetail(repository),
            getWordList = GetWordListById(repository),
            getAcceptedList = GetAllAcceptedList(repository),
            insertAcceptedWord = InsertAcceptedWord(repository),
            deleteAcceptedWod = DeleteAcceptedWord(repository),
            getRejectedList = GetAllRejectedList(repository),
            insertRejectedWord = InsertRejectedWord(repository),
            deleteRejectedWord = DeleteRejectedWord(repository)
        )
    }
}