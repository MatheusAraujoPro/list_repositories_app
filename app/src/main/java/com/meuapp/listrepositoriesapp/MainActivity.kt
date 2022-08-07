package com.meuapp.listrepositoriesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.meuapp.listrepositoriesapp.data.repository.RepoApiImpl
import com.meuapp.listrepositoriesapp.data.repository.RepoRepositoryImpl
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import com.meuapp.listrepositoriesapp.presentation.repolist.RepoListView
import com.meuapp.listrepositoriesapp.presentation.repolist.RepoListViewModel
import com.meuapp.listrepositoriesapp.ui.theme.ListRepositoriesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Executar alguma lógica
        val vm = RepoListViewModel(
            getRepoUseCase = GetRepos(
                repository = RepoRepositoryImpl(
                    dataSource = RepoApiImpl()
                )
            )
        )

        setContent {
            ListRepositoriesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    RepoListView(vm)
                }
            }
        }
    }
}

@Preview(
    name = "Light theme",
    showBackground = true
)
@Composable
fun DefaultPreview() {
    val vm = RepoListViewModel(
        getRepoUseCase = GetRepos(
            repository = RepoRepositoryImpl(
                dataSource = RepoApiImpl()
            )
        )
    )
    ListRepositoriesAppTheme {
        Surface() {
            RepoListView(vm)
        }
    }
}