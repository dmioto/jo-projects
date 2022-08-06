package com.jordan.myrepository.di

import com.jordan.myrepository.data.datasource.RepoDataSource
import com.jordan.myrepository.data.datasource.remote.dto.RepoRemoteDataSource
import com.jordan.myrepository.data.datasource.remote.dto.service.GitHubService
import com.jordan.myrepository.data.repository.RepoRepositoryImpl
import com.jordan.myrepository.domain.repository.RepoRepository
import com.jordan.myrepository.domain.usecase.GetRepoUseCase
import com.jordan.myrepository.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    val io = Dispatchers.IO

    viewModel { ProfileViewModel(get(), io) }

    factory { GetRepoUseCase(get()) }

}