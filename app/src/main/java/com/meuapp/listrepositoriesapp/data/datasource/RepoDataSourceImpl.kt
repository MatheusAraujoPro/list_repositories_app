package com.meuapp.listrepositoriesapp.data.datasource

import com.meuapp.listrepositoriesapp.data.models.getRepo
import com.meuapp.listrepositoriesapp.data.services.ReposWebService
import com.meuapp.listrepositoriesapp.domain.datasource.RepoDataSource
import com.meuapp.listrepositoriesapp.domain.model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoDataSourceImpl(
    private val reposWebService: ReposWebService
) : RepoDataSource {
    override suspend fun getRepos(): List<Repo> {
        return withContext(Dispatchers.IO) {
            reposWebService.getRepos().map { repo -> repo.getRepo() }
        }
    }
}
