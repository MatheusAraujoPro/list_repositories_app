package com.meuapp.listrepositoriesapp.data.repository

import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.datasource.RepoDataSource
import com.meuapp.listrepositoriesapp.domain.repository.RepoRepository

class RepoRepositoryImpl(private val dataSource: RepoDataSource): RepoRepository {
    override suspend fun getRepos(): List<Repo> {
        return dataSource.getRepos()
    }
}