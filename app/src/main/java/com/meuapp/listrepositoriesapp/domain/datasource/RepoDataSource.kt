package com.meuapp.listrepositoriesapp.domain.datasource

import com.meuapp.listrepositoriesapp.domain.model.Repo

interface RepoDataSource {
    suspend fun getRepos(): List<Repo>
}