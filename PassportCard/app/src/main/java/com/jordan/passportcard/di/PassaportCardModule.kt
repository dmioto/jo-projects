package com.jordan.passportcard.di

import android.app.Application
import android.content.Context
import com.jordan.passportcard.data.datasource.AppDatabase
import com.jordan.passportcard.data.datasource.local.PassportCardDao
import com.jordan.passportcard.data.repository.PassportCardRepositoryImpl
import com.jordan.passportcard.domain.repository.PassportCardRepository
import com.jordan.passportcard.domain.usecases.AddPassportCardsUseCase
import com.jordan.passportcard.domain.usecases.GetPassportsCardsUseCase
import com.jordan.passportcard.presentation.addcards.AddCardsViewModel
import com.jordan.passportcard.presentation.showcards.ShowCardsViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    val io = Dispatchers.IO

    viewModel { ShowCardsViewModel(get(), io) }
    viewModel { AddCardsViewModel(get(), io) }

    factory { GetPassportsCardsUseCase(get()) }
    factory { AddPassportCardsUseCase(get()) }
    factory<PassportCardRepository> { PassportCardRepositoryImpl(get()) }

    single { offlinePassportDaoProvider(androidContext()) }
}

// offline forecast dao provider
fun offlinePassportDaoProvider(context: Context): PassportCardDao =
    AppDatabase.getInstance(context).passportCardDao()