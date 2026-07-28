package io.github.ehsankolivand.kmpbase.android

import android.app.Application
import io.github.ehsankolivand.kmpbase.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApplication)
        }
    }
}