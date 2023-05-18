package com.meuapp.listrepositoriesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarDefault(handleBarVisibility: ()-> Unit){
    TopAppBar(
        modifier = Modifier.height(68.dp),
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .padding(6.dp)
                    .clickable {
                        handleBarVisibility()
                    }
            )
        },
        title = {
            Text(text = "My Repositories")
        })
}