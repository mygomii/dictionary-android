package com.mygomii.data.di

import androidx.room.Room
import com.mygomii.data.local.WordDatabase
import com.mygomii.data.repository.WordRepositoryImpl
import com.mygomii.domain.repository.WordRepository
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(get(), WordDatabase::class.java, "word_db").build()
    }

    single { get<WordDatabase>().wordDao() }

    single<WordRepository> { WordRepositoryImpl(get()) }
}
