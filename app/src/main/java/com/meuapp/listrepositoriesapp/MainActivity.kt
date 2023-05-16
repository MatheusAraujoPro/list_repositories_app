package com.meuapp.listrepositoriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.meuapp.listrepositoriesapp.data.repository.RepoApiImpl
import com.meuapp.listrepositoriesapp.data.repository.RepoRepositoryImpl
import com.meuapp.listrepositoriesapp.domain.usecase.GetFilteredRepos
import com.meuapp.listrepositoriesapp.domain.usecase.GetRepos
import com.meuapp.listrepositoriesapp.presentation.repolist.RepoListView
import com.meuapp.listrepositoriesapp.presentation.repolist.RepoListViewModel
import com.meuapp.listrepositoriesapp.ui.theme.ListRepositoriesAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repoListViewModel: RepoListViewModel by viewModel()
        setContent {
            ListRepositoriesAppTheme {
                Surface {
                    RepoListView(repoListViewModel)
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
        ),
        getFilteredReposUseCase = GetFilteredRepos()
    )
    ListRepositoriesAppTheme {
        Surface() {
            RepoListView(vm)
        }
    }
}