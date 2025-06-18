package com.mygomii.dictionary

import android.app.Application
import com.mygomii.dictionary.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WordApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WordApp)
            modules(appModule())
        }
    }
}