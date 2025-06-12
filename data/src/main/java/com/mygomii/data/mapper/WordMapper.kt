package com.mygomii.data.mapper

import com.mygomii.data.local.entity.WordEntity
import com.mygomii.domain.model.Word

fun WordEntity.toDomain(): Word = Word(id, word, meaning)
fun Word.toEntity(): WordEntity = WordEntity(word = word, meaning = meaning)
