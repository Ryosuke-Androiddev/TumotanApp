package com.example.tumotanapp.feature.data.data_source.local.db.dao

import androidx.room.*
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWord
import kotlinx.coroutines.flow.Flow

@Dao
interface RejectedWordDao {

    @Query("SELECT * FROM accepted_word")
    fun getAllRejectedWord(): Flow<List<RejectedWord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRejectedWord(word: RejectedWord)

    @Delete
    suspend fun deleteRejectedWord(word: RejectedWord)
}