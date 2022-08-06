package com.jordan.myrepository.domain.usecase

import com.jordan.myrepository.domain.entity.Repo
import com.jordan.myrepository.domain.mappers.toRepo
import com.jordan.myrepository.domain.repository.RepoRepository

class GetRepoUseCase(private val repository: RepoRepository) {

    suspend fun execute(user: String): List<Repo> {
        return repository.getRepos(user).map { it.toRepo() }
    }
}