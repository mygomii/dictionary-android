package com.mygomii.dictionary.domain.usecase

import com.mygomii.dictionary.domain.model.Word
import com.mygomii.dictionary.domain.repository.WordRepository

class InsertWordUseCase(private val repository: WordRepository) {
    suspend operator fun invoke(word: Word) {
        repository.insertWord(word)
    }
}