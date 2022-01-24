package com.example.tumotanapp.feature.data.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tumotanapp.feature.data.data_source.local.db.dao.AcceptedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.dao.RejectedWordDao
import com.example.tumotanapp.feature.data.data_source.local.db.entity.AcceptedWordEntity
import com.example.tumotanapp.feature.data.data_source.local.db.entity.RejectedWordEntity

@Database(
    entities = [AcceptedWordEntity::class, RejectedWordEntity::class],
    version = 2,
    exportSchema = false
)
abstract class WordDatabase: RoomDatabase() {

    abstract fun acceptedWordDao(): AcceptedWordDao
    abstract fun rejectedWordDao(): RejectedWordDao
}