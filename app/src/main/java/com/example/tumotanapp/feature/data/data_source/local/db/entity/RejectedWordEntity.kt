package com.example.tumotanapp.feature.data.data_source.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tumotanapp.feature.data.util.DataLayerConstants

@Entity(tableName = DataLayerConstants.REJECTEDWORD_TABLE_NAME)
data class RejectedWordEntity(
    @PrimaryKey(autoGenerate = false)
    val wordId: Int,
    val word: String,
    val meaning: String,
    val wordState: Float = 0f,
)
