package com.example.translatetrainer

import android.app.Application
import androidx.room.Room
import com.example.translatetrainer.data.database.SentenceDatabase

class MainApplication : Application() {

    companion object {
        lateinit var sentenceDatabase: SentenceDatabase
    }

    override fun onCreate() {
        super.onCreate()
        sentenceDatabase = Room.databaseBuilder(
            applicationContext,
            SentenceDatabase::class.java,
            SentenceDatabase.NAME
        ).build()
    }
}