package com.meuapp.listrepositoriesapp.di

import com.meuapp.listrepositoriesapp.data.repository.RepoApiImpl
import com.meuapp.listrepositoriesapp.data.repository.RepoRepositoryImpl
import com.meuapp.listrepositoriesapp.domain.repository.RepoDataSource
import com.meuapp.listrepositoriesapp.domain.repository.RepoRepository
import com.meuapp.listrepositoriesapp.domain.usecase.GetFilteredRepos
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import com.meuapp.listrepositoriesapp.presentation.repolist.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModules = module{
  factory { GetRepos( get()) }
  factory { GetFilteredRepos() }
}

val repositoriesModules = module{
  factory<RepoRepository> { RepoRepositoryImpl(get()) }
}

val dataSourceModules = module{
  factory<RepoDataSource> { RepoApiImpl() }
}

val viewModelModules = module {
  viewModel { RepoListViewModel(get(), get()) }
}