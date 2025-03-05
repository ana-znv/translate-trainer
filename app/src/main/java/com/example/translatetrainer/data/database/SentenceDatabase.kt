package com.example.translatetrainer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.translatetrainer.data.Sentence

@Database(entities = [Sentence::class], version = 1)
@TypeConverters(Converters::class)
abstract class SentenceDatabase : RoomDatabase() {
    companion object {
        const val NAME = "Sentence_DB"
    }

    abstract fun getSentenceDao(): SentenceDao
}