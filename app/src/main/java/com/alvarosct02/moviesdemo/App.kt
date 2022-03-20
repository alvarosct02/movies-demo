package com.alvarosct02.moviesdemo

import android.app.Application
import com.alvarosct02.moviesdemo.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                repositoriesModule
            )

        }
    }
}