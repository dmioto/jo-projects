package com.jordan.myrepository.data.datasource.remote.dto.response

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("forks_count") val forks: Int,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("owner") val owner: OwnerResponse
)