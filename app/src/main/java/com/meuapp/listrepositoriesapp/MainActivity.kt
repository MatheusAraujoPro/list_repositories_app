package com.meuapp.listrepositoriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
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