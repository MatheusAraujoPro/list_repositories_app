package com.meuapp.listrepositoriesapp.presentation.repolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meuapp.listrepositoriesapp.domain.model.Repo

@Composable
fun RepoItem(repo: Repo){
 Card(
     elevation = 10.dp,
     modifier = Modifier.padding(10.dp)
 ) {
     Column(modifier = Modifier.padding(10.dp)) {
         Text(text = "Id do repo: ${repo.id}")
         Text(text = "Nome do repo ${repo.name}")
         Text(text = "Descrição do repo ${repo.description}")
     }
 }
}