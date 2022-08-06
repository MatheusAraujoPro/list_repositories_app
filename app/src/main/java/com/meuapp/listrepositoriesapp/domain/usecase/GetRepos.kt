package com.meuapp.listrepositoriesapp.domain.usecase

import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.repository.RepoRepository

class GetRepos(private val repository: RepoRepository) {
    suspend operator fun invoke(): List<Repo>{
        return repository.getRepos()
    }
}