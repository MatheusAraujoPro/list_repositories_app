package com.meuapp.listrepositoriesapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
        Column {
            ImageTec(
                language = if (repo.language.isNullOrEmpty()
                        .not()
                ) "${repo.language}" else stringResource(
                    R.string.repo_no_language
                )
            )
            Content(repo)
        }
    }
}

@Composable
fun ImageTec(language: String) {

    var imgLanguage = ""


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
    Text(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        text = text

    )
    Spacer(modifier = Modifier.height(6.dp))

    Text(
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        text = value,
    )

}

@Composable
fun Content(repo: Repo) {
    Column(modifier = Modifier.padding(14.dp)) {

        Title(text = stringResource(R.string.repo_name), value = repo.name)
        Spacer(modifier = Modifier.height(8.dp))
        Title(
            text = stringResource(R.string.repo_description),
            value = if (repo.description.isNullOrEmpty()
                    .not()
            ) "${repo.description}" else stringResource(
                R.string.repo_no_description
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Title(
            text = stringResource(R.string.repo_language),
            value = if (repo.language.isNullOrEmpty().not()) "${repo.language}" else stringResource(
                R.string.repo_no_language
            )
        )

    }

}


@Composable
@Preview
fun CardPreview() {
    val listOfDummyRepos = listOf(
        Repo(
            id = 1,
            name = "Repo Teste",
            description = "Este é apenas um repo de teste Este é apenas um repo de teste Este é apenas um repo de teste",
            language = "Kotlin"
        ),
        Repo(id = 1, name = "Repo Teste", description = "teste", language = "Kotlin")

    )
    ListRepositoriesAppTheme {
        Surface {
            LazyColumn {
                items(listOfDummyRepos) {
                    RepoItem(repo = it)
                }
            }
        }
    }
}