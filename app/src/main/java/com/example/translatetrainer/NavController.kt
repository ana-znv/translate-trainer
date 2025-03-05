package com.example.translatetrainer

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.translatetrainer.data.SentenceViewModel
import com.example.translatetrainer.ui.screen.AddSentenceScreen
import com.example.translatetrainer.ui.screen.AllSentences
import com.example.translatetrainer.ui.screen.MainScreen
import com.example.translatetrainer.ui.screen.StartTraining

@Composable
fun NavController(viewModel: SentenceViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { MainScreen(navController) }
        composable("add_sentence") { AddSentenceScreen(navController, viewModel) }
        composable("start") { StartTraining(navController) }
        composable("all_sentences") { AllSentences(navController, viewModel) }
    }
}