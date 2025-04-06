package com.mygomii.dictionary.presentation.screen.word

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mygomii.dictionary.presentation.screen.WordViewModel

@Composable
fun WordInputScreen(viewModel: WordViewModel) {
    var word by remember { mutableStateOf("") }
    var meaning by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("단어") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = meaning,
            onValueChange = { meaning = it },
            label = { Text("뜻") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (word.isNotBlank() && meaning.isNotBlank()) {
                    viewModel.addWord(word, meaning)
                    word = ""
                    meaning = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("저장")
        }
    }
}