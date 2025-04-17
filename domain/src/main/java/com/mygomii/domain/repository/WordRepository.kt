package com.mygomii.domain.repository

import com.mygomii.domain.model.Word

interface WordRepository {
    suspend fun getAllWords(): List<Word>
    suspend fun insertWord(word: Word)
}