package com.example.newella.ui.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newella.R
import com.example.newella.ui.theme.seed

@Composable
fun LibraryScreen(

){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
    ) {
        Text(
            text = "Newella",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = seed
        )
        Text(
            text = stringResource(R.string.continue_reading),
            style = MaterialTheme.typography.titleMedium,
        )
        Image(
            painter = painterResource(id = R.drawable.rectangle1),
            contentDescription = stringResource(id = R.string.rectangle1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.continue_creating),
            style = MaterialTheme.typography.titleMedium,
        )
        Image(
            painter = painterResource(id = R.drawable.rectangle1),
            contentDescription = stringResource(id = R.string.rectangle1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        )
    }
}