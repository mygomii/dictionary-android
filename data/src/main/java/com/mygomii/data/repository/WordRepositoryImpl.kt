package com.mygomii.data.repository

import com.mygomii.data.local.dao.WordDao
import com.mygomii.data.local.entity.WordEntity
import com.mygomii.domain.model.Word
import com.mygomii.domain.repository.WordRepository

class WordRepositoryImpl(private val wordDao: WordDao) : WordRepository {
    override suspend fun getAllWords(): List<Word> =
        wordDao.getAllWords().map { entity ->
            Word(id = entity.id, word = entity.word, meaning = entity.meaning)
        }

    override suspend fun insertWord(word: Word) {
        wordDao.insertWord(WordEntity(word = word.word, meaning = word.meaning))
    }
}
