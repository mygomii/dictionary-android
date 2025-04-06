package com.mygomii.dictionary.domain.usecase

import com.mygomii.dictionary.domain.repository.WordRepository

class GetWordsUseCase(
    private val repository: WordRepository
) {
    suspend operator fun invoke() = repository.getAllWords()
}