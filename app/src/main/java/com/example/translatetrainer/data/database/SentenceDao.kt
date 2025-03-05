package com.example.translatetrainer.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.translatetrainer.data.Sentence

@Dao
interface SentenceDao {
    @Query("SELECT * FROM Sentence")
    fun getAllSentences(): LiveData<List<Sentence>>

    @Insert
    fun addSentence(sentence: Sentence)
}