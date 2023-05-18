package com.meuapp.listrepositoriesapp.presentation.repolistscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.usecase.GetFilteredRepos
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import kotlinx.coroutines.launch

class RepoListScreenViewModel constructor(
    private val getRepoUseCase: GetRepos,
    private val getFilteredReposUseCase: GetFilteredRepos
): ViewModel(){
    private val _repos = mutableStateListOf<Repo>()
    val repos: List<Repo> get() = _repos

    suspend fun getRepos(){
        viewModelScope.launch {
            _repos.addAll(getRepoUseCase())
        }
    }

    fun getFilteredRepos(repoName: String): List<Repo>{
        return getFilteredReposUseCase.filterRepos(repoName, repos)
    }
}