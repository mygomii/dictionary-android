package com.mygomii.domain.di

import com.mygomii.domain.usecase.GetWordsUseCase
import com.mygomii.domain.usecase.InsertWordUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetWordsUseCase(get()) }
    single { InsertWordUseCase(get()) }
}