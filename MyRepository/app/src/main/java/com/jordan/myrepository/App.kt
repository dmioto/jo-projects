package com.jordan.myrepository

import android.app.Application
import com.jordan.myrepository.data.DataModule
import com.jordan.myrepository.di.appModule
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

        DataModule.load()
    }

    private fun koinModule(): List<Module> {
        return listOf(
            appModule
        )
    }
}