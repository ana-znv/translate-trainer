package com.example.englishtranslatetrainer.database

import androidx.room.*

interface SentenceDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(sentence: Sentence)

   @Update
   suspend fun update(sentence: Sentence)

   @Delete
   suspend fun delete(sentence: Sentence)

   @Query("SELECT * FROM sentences ORDER BY id DESC")
   fun getAllSentences(): kotlinx.coroutines.flow.Flow<List<Sentence>>
}