package com.example.newella.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newella.R
import com.example.newella.ui.theme.seed

@Composable
fun SearchScreen(
    onToNovelClick: () -> Unit

){
    var textSearch by remember { mutableStateOf("Крутое") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Newella",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = seed
        )
        Spacer(Modifier.height(32.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = textSearch,
                onValueChange = { textSearch = it },
                label = { Text("Поиск") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Новинки",
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }
                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
            }
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Популярное",
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)

                )
            }
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Обновления",
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(100.dp, 100.dp)
                        .clickable { onToNovelClick() }


                )
            }
        }
    }
}