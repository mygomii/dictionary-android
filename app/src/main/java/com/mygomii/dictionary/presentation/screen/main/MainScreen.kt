package com.mygomii.dictionary.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mygomii.dictionary.presentation.data.Screen
import com.mygomii.dictionary.presentation.screen.WordViewModel
import com.mygomii.dictionary.presentation.screen.components.BottomNavigationBar
import com.mygomii.dictionary.presentation.screen.mypage.MyPageScreen
import com.mygomii.dictionary.presentation.screen.word.FlashcardScreen
import com.mygomii.dictionary.presentation.screen.word.WordInputScreen

@Composable
fun MainScreen(viewModel: WordViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.WordInput.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.WordInput.route) {
                WordInputScreen(viewModel = viewModel)
            }
            composable(Screen.Flashcard.route) {
                FlashcardScreen(viewModel = viewModel)
            }
            composable(Screen.MyPage.route) {
                MyPageScreen()
            }
        }
    }
}