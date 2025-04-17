package com.mygomii.dictionary.presentation.data

sealed class Screen(val route: String, val title: String) {
    data object WordInput : Screen("word_input", "단어 입력")
    data object Flashcard : Screen("flashcard", "플래시카드")
    data object MyPage : Screen("my_page", "마이페이지")
}