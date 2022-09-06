package com.meuapp.listrepositoriesapp.presentation.repolist

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarSearch(
    text: String,
    handleBarVisibility: () -> Unit,
    handleSearchRepo: (repoName: String) -> Unit,

) {
    TopAppBar(
        modifier = Modifier
            .height(68.dp),
        backgroundColor = MaterialTheme.colors.primary,

        ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Go back",
            modifier = Modifier.clickable {
                handleBarVisibility()
            },
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            value = text,
            modifier = Modifier.fillMaxWidth(
                fraction = 0.955f
            ),
            placeholder = {
                Text(text = "Pesquisar...")
            },
            onValueChange = { value ->
                handleSearchRepo(value)
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            maxLines = 1
        )
    }
}
