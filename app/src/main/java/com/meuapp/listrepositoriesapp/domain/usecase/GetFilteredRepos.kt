package com.meuapp.listrepositoriesapp.domain.usecase

import com.meuapp.listrepositoriesapp.domain.model.Repo

class GetFilteredRepos {
    fun filterRepos(repoName: String, repoList: List<Repo>): List<Repo> {
        return repoList.filter { repo -> repo.name.startsWith(repoName)  }
    }
}