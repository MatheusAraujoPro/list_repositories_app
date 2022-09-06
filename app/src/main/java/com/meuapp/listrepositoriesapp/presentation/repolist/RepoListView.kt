package com.meuapp.listrepositoriesapp.presentation.repolist

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meuapp.listrepositoriesapp.domain.model.Repo


@Composable
fun RepoListView(vm: RepoListViewModel) {
    var isAppBarSearchVisibility by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var listReposOnScrean by remember { mutableStateOf(listOf<Repo>()) }

    fun handleBarVisibility(): Unit {
        isAppBarSearchVisibility = !isAppBarSearchVisibility
    }

    /***
     * Assim que a tela carrega, ele chama o
     * método getRepos da ViewModel
     */

    LaunchedEffect(Unit, block = {
        vm.getRepos()
    })

    Scaffold(
        topBar = {
            if (isAppBarSearchVisibility) {
                TopAppBarSearch(
                    text,
                    handleBarVisibility = { handleBarVisibility() },
                    handleSearchRepo = { repoName ->
                        text = repoName
                        listReposOnScrean = vm.getFilteredRepos(repoName)
                    }
                )
            } else {
                TopAppBarDefault { handleBarVisibility() }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally


            ) {
                // Trabalhando com listas
                if (vm.repos.isEmpty()) {
                    CircularProgressIndicator()

                } else {
                    listReposOnScrean = vm.repos
                    LazyColumn() {
                        //Pegando o item da Iteração
                        items(listReposOnScrean) { repo ->
                            RepoItem(repo = repo)
                        }
                    }

                }
            }
        }
    )
}

