package com.lihan.dogproject

import android.app.Application
import com.lihan.dogproject.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DogApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DogApplication)
            modules(
                appModules
            )
        }
    }
}