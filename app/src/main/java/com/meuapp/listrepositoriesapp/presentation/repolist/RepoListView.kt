package com.meuapp.listrepositoriesapp.presentation.repolist

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.coroutines.coroutineContext

@Composable
fun RepoListView(vm: RepoListViewModel) {
    /***
     * Assim que a tela carrega, ele chama o
     * método getRepos da ViewModel
     */
    LaunchedEffect(Unit, block = {
        vm.getRepos()
    })

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "My Repositories")
            })

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
                    // loadedList = vm.repos.size
                    LazyColumn() {
                        //Pegando o item da Iteração
                        items(vm.repos) { repo ->
                            RepoItem(repo = repo)
                        }
                    }

                }
            }
        }
    )
}