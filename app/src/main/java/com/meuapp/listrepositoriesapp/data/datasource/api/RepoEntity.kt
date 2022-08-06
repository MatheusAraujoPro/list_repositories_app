package com.meuapp.listrepositoriesapp.data.datasource.api

import com.meuapp.listrepositoriesapp.domain.model.Repo

data class RepoEntity(
    val id: Int,
    val name: String,
    val description: String?
)

fun RepoEntity.getRepo(): Repo{
    return Repo(
        id = id,
        name = name,
        description = description
    )
}
