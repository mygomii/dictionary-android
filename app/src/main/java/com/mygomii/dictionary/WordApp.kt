package com.mygomii.dictionary

import android.app.Application
import android.widget.Toast
import com.mygomii.dictionary.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WordApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Toast.makeText(this, "테스트입니다.", Toast.LENGTH_SHORT).show()
        startKoin {
            androidContext(this@WordApp)
            modules(appModule())
        }
    }
}