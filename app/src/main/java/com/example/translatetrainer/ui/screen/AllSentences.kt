package com.example.translatetrainer.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.translatetrainer.data.Sentence
import com.example.translatetrainer.data.SentenceViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun AllSentences(viewModel: SentenceViewModel) {
    val sentenceList by viewModel.sentenceList.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        sentenceList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { index, item ->
                        SentenceItem(item = item)
                    }
                }
            )
        }
    }
}

@Composable
fun SentenceItem(item: Sentence) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Text(
                text = "Native: " + item.native,
                fontSize = 20.sp,
                color = Color.White
            )
            Text(
                text = "Foreign: " + item.foreign,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}