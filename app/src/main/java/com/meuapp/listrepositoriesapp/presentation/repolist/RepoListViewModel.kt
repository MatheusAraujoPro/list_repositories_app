package com.meuapp.listrepositoriesapp.presentation.repolist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import kotlinx.coroutines.launch

class RepoListViewModel constructor(
    private val getRepoUseCase: GetRepos
): ViewModel(){
    private val _repos = mutableStateListOf<Repo>()

    val repos: List<Repo> get() = _repos

    suspend fun getRepos(){
        viewModelScope.launch {
            _repos.addAll(getRepoUseCase())
        }
    }
}