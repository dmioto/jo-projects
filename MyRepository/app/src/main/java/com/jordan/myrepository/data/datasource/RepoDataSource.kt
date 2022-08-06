package com.jordan.myrepository.data.datasource

import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse

interface RepoDataSource {
    suspend fun requestRepos(user: String) : List<RepoResponse>
}