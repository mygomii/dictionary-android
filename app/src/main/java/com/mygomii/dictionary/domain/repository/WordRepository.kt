package com.mygomii.dictionary.domain.repository

import com.mygomii.dictionary.domain.model.Word

interface WordRepository {
    suspend fun getAllWords(): List<Word>
    suspend fun insertWord(word: Word)
}