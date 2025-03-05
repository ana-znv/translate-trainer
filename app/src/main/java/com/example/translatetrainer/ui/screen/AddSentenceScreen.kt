package com.example.translatetrainer.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.translatetrainer.data.SentenceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSentenceScreen(navController: NavController, viewModel: SentenceViewModel) {

    var nativeText by remember {
        mutableStateOf("")
    }

    var foreignText by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
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
                        text = "Add Sentence",
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    },
                    modifier = Modifier.fillMaxWidth()
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
                    },
                    modifier = Modifier.fillMaxWidth()

                )
            }
            Button(
                onClick = {
                    viewModel.addSentence(nativeText, foreignText)
                    nativeText = ""
                    foreignText = ""
                }
            ) {
                Text(
                    text = "Add",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }

}