package com.example.translatetrainer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.translatetrainer.data.SentenceViewModel
import com.example.translatetrainer.ui.screen.AddSentenceScreen
import com.example.translatetrainer.ui.screen.AllSentences
import com.example.translatetrainer.ui.screen.MainScreen
import com.example.translatetrainer.ui.screen.StartTraining

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home: Screen("home", "Home", Icons.Default.Home)
    data object AddSentence: Screen("add_sentence", "Add", Icons.Default.Add)
    data object Start: Screen("start", "Train", Icons.Default.PlayArrow)
    data object AllSentences: Screen("all_sentences", "Sentences", Icons.AutoMirrored.Filled.List)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.AddSentence,
    Screen.Start,
    Screen.AllSentences
)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val currentRoute = navController.currentDestination?.route
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) }
            )
        }
    }
}

@Composable
fun NavController(navController: NavHostController ,viewModel: SentenceViewModel) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { MainScreen(viewModel) }
        composable(Screen.AddSentence.route) { AddSentenceScreen(navController, viewModel) }
        composable(Screen.Start.route) { StartTraining(navController, viewModel) }
        composable(Screen.AllSentences.route) { AllSentences(navController, viewModel) }
    }
}