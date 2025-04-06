package com.mygomii.dictionary.presentation.screen.word

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mygomii.dictionary.presentation.screen.WordViewModel

@Composable
fun FlashcardScreen(viewModel: WordViewModel) {
    val words by viewModel.words.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(words.size) { index ->
            Flashcard(word = words[index])
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}