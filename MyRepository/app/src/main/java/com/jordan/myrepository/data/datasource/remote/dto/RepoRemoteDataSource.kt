package com.jordan.myrepository.data.datasource.remote.dto

import android.os.RemoteException
import com.jordan.myrepository.data.datasource.RepoDataSource
import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse
import com.jordan.myrepository.data.datasource.remote.dto.service.GitHubService
import retrofit2.HttpException


class RepoRemoteDataSource(private val service: GitHubService) : RepoDataSource {

    companion object {
        private const val BASE_URL = "https://jordan-moura.github.io/Women-s-Soccer-News-Api/"
    }

    override suspend fun requestRepos(user: String): List<RepoResponse> {
        try {
            return service.getRepositories(user)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}