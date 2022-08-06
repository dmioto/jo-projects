package com.jordan.myrepository.domain.mappers

import com.jordan.myrepository.data.datasource.remote.dto.response.RepoResponse
import com.jordan.myrepository.domain.entity.Repo

fun RepoResponse.toRepo(): Repo {
    return let {
        Repo(
            name = it.name,
            description = it.description ?: "",
            forks = it.forks.toString(),
            stars = it.stars.toString(),
            owner = it.owner.login
        )
    }
}