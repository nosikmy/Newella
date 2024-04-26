package com.example.newella.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newella.R
import com.example.newella.ui.theme.seed


@Composable
fun ProfileScreen(

){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse1),
            contentDescription = stringResource(id = R.string.ellipse1),
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(150.dp, 150.dp)
        )
        Text(
            text = "Имя",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = "email@gmail.com",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.subscribes),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(Modifier.weight(1f))
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.subscribers),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(R.string.subscribe),
            )
        }
        Spacer(modifier = Modifier.size(32.dp))

        FilledTonalButton(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth() ) {
            Text(
                text = "О себе",
            )
        }
        FilledTonalButton(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth() ) {
            Text(
                text = "История",
            )
        }
        FilledTonalButton(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth() ) {
            Text(
                text = "Оценки",
            )
        }
        FilledTonalButton(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Настройки",
            )
        }
    }
}