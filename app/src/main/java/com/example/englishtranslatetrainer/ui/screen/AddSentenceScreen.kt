package com.example.englishtranslatetrainer.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSentenceScreen(navController: NavController) {
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
         NativeSentence()
      }
   }
}

@Composable
fun NativeSentence() {
   var text by remember { mutableStateOf("") }
   var result by remember { mutableStateOf("") }

   Column {
      OutlinedTextField(
         modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 20.dp),
         value = text,
         onValueChange = { text = it },
         label = {
            Text(
               "Native Sentence",
               style = TextStyle(
                  fontSize = 20.sp
               )
            )
         },
         maxLines = Int.MAX_VALUE,
         keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default)
      )
      Spacer(Modifier.height(10.dp))
      Button(
         modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 20.dp),
         onClick = { result = text }
      ) {
         Text("click")
      }
      Text(text = result)
   }
}