package com.meuapp.listrepositoriesapp.domain.repository

import com.meuapp.listrepositoriesapp.domain.model.Repo

interface RepoRepository {
    suspend fun getRepos(): List<Repo>
}