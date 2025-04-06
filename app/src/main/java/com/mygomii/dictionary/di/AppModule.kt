package com.mygomii.dictionary.di

import androidx.room.Room
import com.mygomii.dictionary.data.local.WordDatabase
import com.mygomii.dictionary.data.repository.WordRepositoryImpl
import com.mygomii.dictionary.domain.repository.WordRepository
import com.mygomii.dictionary.domain.usecase.GetWordsUseCase
import com.mygomii.dictionary.domain.usecase.InsertWordUseCase
import com.mygomii.dictionary.presentation.screen.WordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), WordDatabase::class.java, "word_db").build()
    }
    single { get<WordDatabase>().wordDao() }

    single<WordRepository> { WordRepositoryImpl(get()) }

    single { GetWordsUseCase(get()) }
    single { InsertWordUseCase(get()) }

    viewModel { WordViewModel(get(), get()) }
}