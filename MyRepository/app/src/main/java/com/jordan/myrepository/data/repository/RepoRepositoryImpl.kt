package com.jordan.myrepository.data.repository

import com.jordan.myrepository.data.datasource.RepoDataSource
import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse
import com.jordan.myrepository.domain.repository.RepoRepository

class RepoRepositoryImpl(private val dataSource: RepoDataSource) : RepoRepository {

    override suspend fun getRepos(user: String): List<RepoResponse> {
        return dataSource.requestRepos(user)
    }
}