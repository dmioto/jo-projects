package com.jordan.myrepository.domain.entity

data class Repo(
    val name: String,
    val description: String,
    val forks: String,
    val stars: String,
    val owner: String
)