package com.example.translatetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.translatetrainer.data.SentenceViewModel
import com.example.translatetrainer.ui.theme.TranslateTrainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TranslateTrainerTheme {
                Scaffold(modifier = Modifier.fillMaxSize().statusBarsPadding()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        val viewModel = SentenceViewModel()
                        NavController(viewModel)
                    }
                }
            }
        }
    }
}