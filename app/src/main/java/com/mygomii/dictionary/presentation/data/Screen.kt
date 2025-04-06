package com.mygomii.dictionary.presentation.data

sealed class Screen(val route: String, val title: String) {
    object WordInput : Screen("word_input", "단어 입력")
    object Flashcard : Screen("flashcard", "플래시카드")
    object MyPage : Screen("my_page", "마이페이지")
}