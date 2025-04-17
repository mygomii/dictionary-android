package com.mygomii.domain.usecase

import com.mygomii.domain.model.Word
import com.mygomii.domain.repository.WordRepository

class InsertWordUseCase(private val repository: WordRepository) {
    suspend operator fun invoke(word: Word) {
        repository.insertWord(word)
    }
}