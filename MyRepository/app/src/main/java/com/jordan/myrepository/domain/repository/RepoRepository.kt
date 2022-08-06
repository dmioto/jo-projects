package com.jordan.myrepository.domain.repository

import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse

interface RepoRepository {
    suspend fun getRepos(user: String) : List<RepoResponse>
}