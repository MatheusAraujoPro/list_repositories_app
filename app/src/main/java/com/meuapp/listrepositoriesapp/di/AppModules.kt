package com.meuapp.listrepositoriesapp.di

import com.meuapp.listrepositoriesapp.data.datasource.RepoDataSourceImpl
import com.meuapp.listrepositoriesapp.data.provideGitHubWebService
import com.meuapp.listrepositoriesapp.data.provideRetrofit
import com.meuapp.listrepositoriesapp.data.repository.RepoRepositoryImpl
import com.meuapp.listrepositoriesapp.domain.datasource.RepoDataSource
import com.meuapp.listrepositoriesapp.domain.repository.RepoRepository
import com.meuapp.listrepositoriesapp.domain.usecase.GetFilteredRepos
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import com.meuapp.listrepositoriesapp.presentation.repolistscreen.RepoListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModules = module {
    factory { GetRepos(get()) }
    factory { GetFilteredRepos() }
}

val repositoriesModules = module {
    factory<RepoRepository> { RepoRepositoryImpl(get()) }
}

val dataSourceModules = module {
    factory<RepoDataSource> { RepoDataSourceImpl(get()) }
}

val viewModelModules = module {
    viewModel { RepoListScreenViewModel(get(), get()) }
}

val networkModel = module {
    single { provideRetrofit() }
    factory { provideGitHubWebService(get()) }
}