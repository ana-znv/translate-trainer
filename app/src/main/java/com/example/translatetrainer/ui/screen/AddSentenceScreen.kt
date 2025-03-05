package com.example.translatetrainer.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.translatetrainer.data.SentenceViewModel

@Composable
fun AddSentenceScreen(navController: NavController, viewModel: SentenceViewModel) {

    var nativeText by remember {
        mutableStateOf("")
    }

    var foreignText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = nativeText,
                onValueChange = {
                    nativeText = it
                },
                label = {
                    Text(text = "Native Sentence")
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = foreignText,
                onValueChange = {
                    foreignText = it
                },
                label = {
                    Text(text = "Foreign Sentence")
                }
            )
        }
        Button(
            onClick = {
                viewModel.addSentence(nativeText, foreignText)
                nativeText = ""
                foreignText = ""
            }
        ) {
            Text(text = "Add")
        }
    }
}