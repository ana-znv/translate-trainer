package com.example.englishtranslatetrainer.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sentences")
data class Sentence(
   @PrimaryKey(autoGenerate = true) val id: Int = 0,
   val native: String,
   val foreign: String
)
