package com.jordan.myrepository.data.datasource.remote.dto.response

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login") val login: String,
)
