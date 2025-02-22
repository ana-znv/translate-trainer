package com.example.englishtranslatetrainer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sentence::class], version = 1, exportSchema = false)
abstract class SentenceDatabase : RoomDatabase() {
   abstract fun sentenceDao(): SentenceDao

   companion object{
      @Volatile
      private var INSTANCE: SentenceDatabase? = null

      fun getDatabase(context: Context): SentenceDatabase {
         return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
               context.applicationContext,
               SentenceDatabase::class.java,
               "sentence_database"
            ).build()
            INSTANCE = instance
            instance
         }
      }
   }
}