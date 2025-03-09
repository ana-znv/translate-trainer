package com.example.translatetrainer.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.translatetrainer.data.SentenceViewModel

@Composable
fun MainScreen(viewModel: SentenceViewModel) {
    val sentenceList by viewModel.sentenceList.observeAsState()

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .fillMaxWidth(0.45f),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Text(
                text = "Count of sentence:\n" + sentenceList?.size,
                modifier = Modifier
                    .padding(15.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        ElevatedCard(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Text(
                text = "You solved:\n$solved",
                modifier = Modifier
                    .padding(15.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
