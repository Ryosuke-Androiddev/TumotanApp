package com.example.tumotanapp.di.module

import com.example.tumotanapp.feature.data.data_source.remote.TumotanApi
import com.example.tumotanapp.feature.data.repository.TumotanRepositoryImpl
import com.example.tumotanapp.feature.domain.repository.TumotanRepository
import com.example.tumotanapp.feature.domain.use_case.GetAllRoom
import com.example.tumotanapp.feature.domain.use_case.unite.UseCase
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
    fun provideTumotanRepository(api: TumotanApi): TumotanRepository {
        return TumotanRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: TumotanRepository): UseCase{
        return UseCase(
            getAllRoom = GetAllRoom(repository)
        )
    }
}