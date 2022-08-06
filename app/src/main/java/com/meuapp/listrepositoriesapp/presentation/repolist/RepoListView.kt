package com.meuapp.listrepositoriesapp.presentation.repolist

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.coroutines.coroutineContext

@Composable
fun RepoListView(vm: RepoListViewModel){
    /***
     * Assim que a tela carrega, ele chama o 
     * método getRepos da ViewModel
     */
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit, block = {
        val list = vm.getRepos()

    })
    
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "My Repositories")
            } ) 
                        
        },
        content = {
            Column(modifier = Modifier.padding(16.dp)) {
                // Trabalhando com listas
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    //Pegando o item da Iteração
                    items(vm.repos){ repo ->
                        RepoItem(repo = repo)
                    }
                }
            }
        }
    )
}