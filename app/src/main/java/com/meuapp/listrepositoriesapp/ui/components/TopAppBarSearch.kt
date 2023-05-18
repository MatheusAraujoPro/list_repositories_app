package com.meuapp.listrepositoriesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meuapp.listrepositoriesapp.R

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
            contentDescription = stringResource(R.string.button_go_back_text),
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
                Text(text = stringResource(R.string.text_find_placeholder))
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
