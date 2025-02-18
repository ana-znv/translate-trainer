package com.example.englishtranslatetrainer

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.englishtranslatetrainer.ui.screen.AddSentenceScreen
import com.example.englishtranslatetrainer.ui.screen.HomeScreen
import com.example.englishtranslatetrainer.ui.screen.TrainingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("training") { TrainingScreen() }
        composable("add_sentence") { AddSentenceScreen(navController) }
    }
}