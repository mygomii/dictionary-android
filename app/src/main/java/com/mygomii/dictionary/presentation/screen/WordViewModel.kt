package com.mygomii.dictionary.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mygomii.dictionary.domain.model.Word
import com.mygomii.dictionary.domain.usecase.GetWordsUseCase
import com.mygomii.dictionary.domain.usecase.InsertWordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WordViewModel(
    private val getWordsUseCase: GetWordsUseCase,
    private val insertWordUseCase: InsertWordUseCase
) : ViewModel() {
    private val _words = MutableStateFlow<List<Word>>(emptyList())
    val words: StateFlow<List<Word>> = _words

    init {
        loadWords()
    }

    private fun loadWords() {
        viewModelScope.launch {
            _words.value = getWordsUseCase()
        }
    }

    fun addWord(wordText: String, meaningText: String) {
        viewModelScope.launch {
            insertWordUseCase(Word(word = wordText, meaning = meaningText))
            loadWords()
        }
    }
}