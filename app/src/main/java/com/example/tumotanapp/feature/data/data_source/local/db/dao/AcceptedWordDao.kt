package com.example.tumotanapp.feature.data.data_source.local.db.dao

import androidx.room.*
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity

@Dao
interface AcceptedWordDao {

    @Query("SELECT * FROM accepted_word")
    suspend fun getAllAcceptedWord(): List<AcceptedWordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAcceptedWord(word: AcceptedWordEntity)

    @Delete
    suspend fun deleteAcceptedWord(word: AcceptedWordEntity)

    @Query("SELECT * FROM accepted_word WHERE roomLevelId=:roomLevelId")
    suspend fun getAcceptedWordById(roomLevelId: Int): List<AcceptedWordEntity>
}