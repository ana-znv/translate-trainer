package com.example.translatetrainer.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Sentence(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var native: String,
    var foreign: String,
    var createdAt: Date
)
