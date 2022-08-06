package com.jordan.passportcard

import android.app.Application
import com.jordan.passportcard.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(koinModule())
        }
    }

    private fun koinModule(): List<Module> {
        return listOf(
            appModule
        )
    }
}