package com.example.translatetrainer.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.translatetrainer.data.Sentence
import com.example.translatetrainer.data.SentenceViewModel

var solved = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartTraining(navController: NavHostController, viewModel: SentenceViewModel) {
    val sentenceList by viewModel.sentenceList.observeAsState()
    var randomElement by remember {
        mutableStateOf<Sentence?>(null)
    }
    var answer by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    LaunchedEffect(sentenceList) {
        randomElement = sentenceList?.takeIf { it.isNotEmpty() }?.random()
    }



    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(bottom = 15.dp),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Get back",
                            tint = Color(0xFFE7E7E7)
                        )
                    }
                },
                title = {
                    Text(
                        text = "Train",
                        color = Color(0xFFE7E7E7),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        if (randomElement != null) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp)
                ) {
                    randomElement?.let {
                        Text(
                            text = it.native,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
                OutlinedTextField(
                    value = answer,
                    onValueChange = {
                        answer = it
                    },
                    label = {
                        Text(
                            text = "Your answer",
                            fontSize = 16.sp
                        )
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Button(onClick = {
                    if (randomElement != null) {
                        if (randomElement!!.foreign == answer) {
                            solved++
                            result = "You're right!"
                            viewModel.deleteSentence(randomElement!!.id)
                            answer = ""
                        } else {
                            result = "You're made a mistake!"
                            answer = ""
                            randomElement = sentenceList?.takeIf { it.isNotEmpty() }?.random()
                        }
                    }
                }
                ) {
                    Text(text = "Compare")
                }
                Text(text = result)
            }
        } else {
            Text(
                text = "You do not have sentences yet"
            )
        }
    }
}