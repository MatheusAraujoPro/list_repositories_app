package com.meuapp.listrepositoriesapp.presentation.repolistscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.meuapp.listrepositoriesapp.R
import com.meuapp.listrepositoriesapp.domain.constants.RepoConstants
import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.ui.theme.ListRepositoriesAppTheme

@Composable
fun RepoItem(repo: Repo) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {

            ImageTec(language = if (repo.language !== null) "${repo.language}" else stringResource(R.string.repo_no_language))
            Title(text = stringResource(R.string.repo_name), value = repo.name)
            Spacer(modifier = Modifier.height(10.dp))
            Title(
                text = stringResource(R.string.repo_description),
                value = if (repo.description !== null) "${repo.description}" else stringResource(R.string.repo_no_description)
            )
            Title(
                text = stringResource(R.string.repo_language),
                value = if (repo.language !== null) "${repo.language}" else stringResource(R.string.repo_no_language)
            )

        }
    }
}

@Composable
fun ImageTec(language: String) {

    var imgLanguage: String = ""


    when (language) {
        "TypeScript" -> imgLanguage = RepoConstants.TYPESCPRIPT
        "JavaScript" -> imgLanguage = RepoConstants.JAVASCRIPT
        "Java" -> imgLanguage = RepoConstants.JAVA
        "Kotlin" -> imgLanguage = RepoConstants.KOTLIN
        "HTML" -> imgLanguage = RepoConstants.HTML
        "Sem Linguagem" -> imgLanguage = RepoConstants.DEFAULT
    }


    AsyncImage(
        modifier = Modifier
            .fillMaxWidth(),

        model = imgLanguage,
        contentDescription = "Teste da Lib"
    )

}


@Composable
fun Title(text: String, value: String) {
    Column {
        Text(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            text = "$text"

        )
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            fontSize = 20.sp,
            text = "$value",
            fontWeight = FontWeight.Light
        )
    }
}


@Composable
@Preview
fun CardPreview() {
    val repo = Repo(
        id = 1,
        name = "Repo Teste",
        description = "Este é apenas um repo de teste Este é apenas um repo de teste Este é apenas um repo de teste",
        language = "Kotlin"
    )
    val repo2 = Repo(id = 1, name = "Repo Teste", description = "teste", language = "Kotlin")
    ListRepositoriesAppTheme {
        Surface() {
            Column() {
                RepoItem(repo)
                RepoItem(repo2)
            }

        }
    }
}