package com.example.englishtranslatetrainer.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSentence(navController: NavController) {
   Scaffold(
      topBar = {
         TopAppBar(
            title = {
               Row(
                  verticalAlignment = Alignment.CenterVertically
               ) {
                  IconButton(
                     modifier = Modifier.padding(end = 7.dp),
                     onClick = {
                        navController.popBackStack()
                     }
                  ) {
                     Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xFF039be5)
                     )
                  }
                  Text(
                     "Add Sentence",
                     style = TextStyle(
                        fontSize = 30.sp
                     )
                  )
               }
            }
         )
      },
   ) { innerPadding ->
      Column(
         modifier = Modifier.padding(innerPadding)
      ) {
         Spacer(Modifier.height(30.dp))
         InputForSentence("Native Sentence")
         Spacer(Modifier.height(30.dp))
         InputForSentence("Foreign Sentence")
         Spacer(Modifier.height(50.dp))
         Button(
            modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)
               .height(60.dp),
            onClick = {}
         ) {
            Text(
               "Done",
               style = TextStyle(
                  fontSize = 30.sp,
                  fontWeight = FontWeight.Medium
               )
            )
         }
      }
   }
}

@Composable
fun InputForSentence(contentLabel: String) {
   var text by remember { mutableStateOf("") }

   Column {
      OutlinedTextField(
         modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
         value = text,
         onValueChange = { text = it },
         label = {
            Text(
               contentLabel,
               style = TextStyle(
                  fontSize = 20.sp
               )
            )
         },
         maxLines = Int.MAX_VALUE,
         keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default)
      )
   }
}