package com.example.newella.ui.novel

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newella.R

@Composable
fun NovelScreen(

){
    Column {
        Image(
            painter = painterResource(id = R.drawable.rectangle3),
            contentDescription = stringResource(id = R.string.rectangle3),
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp, 250.dp)
        )
        Column (
            modifier = Modifier
                .padding(16.dp),
        ){
            Text(
                text = "Название",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Рейтинг",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.inversePrimary
            )
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Описание",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Очень интересная новелла об интересных вещах с интересными людьми",
                style = MaterialTheme.typography.bodyMedium,
            )
        }


    }
}