package com.example.translatetrainer.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatetrainer.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class SentenceViewModel : ViewModel() {

    val sentenceDao = MainApplication.sentenceDatabase.getSentenceDao()

    val sentenceList: LiveData<List<Sentence>> = sentenceDao.getAllSentences()

    fun addSentence(native: String, foreign: String) {
        viewModelScope.launch(Dispatchers.IO) {
            sentenceDao.addSentence(Sentence(
                native = native,
                foreign = foreign,
                createdAt = Date.from(Instant.now())
            ))
        }
    }
}