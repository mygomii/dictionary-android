package com.mygomii.dictionary.di

import com.mygomii.data.di.dataModule
import com.mygomii.dictionary.presentation.screen.WordViewModel
import com.mygomii.domain.di.domainModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = listOf(
    dataModule,
    domainModule,
    viewModelModule
)


val viewModelModule = module {
    viewModel { WordViewModel(get(), get()) }
}