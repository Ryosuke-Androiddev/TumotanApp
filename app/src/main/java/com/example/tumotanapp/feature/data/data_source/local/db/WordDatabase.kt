package com.example.tumotanapp.feature.data.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tumotanapp.feature.data.data_source.local.db.dao.AcceptedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.dao.RejectedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWord
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWord

@Database(
    entities = [AcceptedWord::class, RejectedWord::class],
    version = 1
)
abstract class WordDatabase: RoomDatabase() {

    abstract fun acceptedWordDao(): AcceptedWordDao
    abstract fun rejectedWordDao(): RejectedWordDao
}