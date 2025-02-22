package com.example.englishtranslatetrainer.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SentenceViewModel(application: Application) : AndroidViewModel(application) {
   private val db = SentenceDatabase.getDatabase(application)
   private val sentenceDao = db.sentenceDao()

   val allSentences: LiveData<List<Sentence>> = sentenceDao.getAllSentences().asLiveData()

   fun insert(sentence: Sentence) = viewModelScope.launch {
      sentenceDao.insert(sentence)
   }

   fun update(sentence: Sentence) = viewModelScope.launch {
      sentenceDao.update(sentence)
   }

   fun delete(sentence: Sentence) = viewModelScope.launch {
      sentenceDao.delete(sentence)
   }
}