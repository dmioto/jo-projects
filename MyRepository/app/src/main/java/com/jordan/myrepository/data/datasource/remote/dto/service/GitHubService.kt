package com.jordan.myrepository.data.datasource.remote.dto.service

import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun getRepositories(@Path("user") user: String) : List<RepoResponse>
}