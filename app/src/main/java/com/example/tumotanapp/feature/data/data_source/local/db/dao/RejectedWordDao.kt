package com.example.tumotanapp.feature.data.data_source.local.db.dao

import androidx.room.*
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity

@Dao
interface RejectedWordDao {

    @Query("SELECT * FROM rejected_word")
    suspend fun getAllRejectedWord(): List<RejectedWordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRejectedWord(word: RejectedWordEntity)

    @Delete
    suspend fun deleteRejectedWord(word: RejectedWordEntity)
}