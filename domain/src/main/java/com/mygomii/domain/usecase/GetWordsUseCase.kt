package com.mygomii.domain.usecase

import com.mygomii.domain.repository.WordRepository

class GetWordsUseCase(
    private val repository: WordRepository
) {
    suspend operator fun invoke() = repository.getAllWords()
}