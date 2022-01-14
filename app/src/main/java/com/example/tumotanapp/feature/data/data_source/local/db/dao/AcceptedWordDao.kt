package com.example.tumotanapp.feature.data.data_source.local.db.dao

import androidx.room.*
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWord
import kotlinx.coroutines.flow.Flow

@Dao
interface AcceptedWordDao {

    @Query("SELECT * FROM accepted_word")
    fun getAllAcceptedWord(): Flow<List<AcceptedWord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAcceptedWord(word: AcceptedWord)

    @Delete
    suspend fun deleteAcceptedWord(word: AcceptedWord)
}