package com.meuapp.listrepositoriesapp.presentation.repolistscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.ui.components.RepoItem
import org.koin.androidx.compose.getViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RepoListScreen(vm: RepoListScreenViewModel = getViewModel()) {
    var isAppBarSearchVisibility by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var listReposOnScrean by remember { mutableStateOf(listOf<Repo>()) }

    fun handleBarVisibility() {
        isAppBarSearchVisibility = !isAppBarSearchVisibility
    }

    LaunchedEffect(Unit, block = {
        vm.getRepos()
    })

    Scaffold(
        topBar = {
            if (isAppBarSearchVisibility) {
                TopAppBarSearch(
                    text = text,
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
                if (vm.repos.isEmpty()) {
                    CircularProgressIndicator()
                } else {
                    listReposOnScrean = vm.repos
                    LazyColumn {
                        items(listReposOnScrean) { repo ->
                           RepoItem(repo = repo )
                        }
                    }
                }
            }
        }
    )
}

