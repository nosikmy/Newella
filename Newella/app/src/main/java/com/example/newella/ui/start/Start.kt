package com.example.newella.ui.start

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newella.R
import com.example.newella.ui.theme.seed


@Composable
fun StartScreen(
    onNextButtonClicked: () -> Unit,
) {

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Newella",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = seed
        )
        Spacer(Modifier.height(32.dp))
        Column (
            //horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(R.string.welcome),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Для вас",
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Image(
                    painter = painterResource(id = R.drawable.ellipse1),
                    contentDescription = stringResource(id = R.string.ellipse1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse1),
                    contentDescription = stringResource(id = R.string.ellipse1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse1),
                    contentDescription = stringResource(id = R.string.ellipse1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse1),
                    contentDescription = stringResource(id = R.string.ellipse1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse1),
                    contentDescription = stringResource(id = R.string.ellipse1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Новинки от любимых авторов",
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
                        .size(150.dp, 150.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle2),
                    contentDescription = stringResource(id = R.string.rectangle2),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(150.dp, 150.dp)
                )
            }
            Spacer(Modifier.height(32.dp))

            Text(
                text = "Продолжить",
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle1),
                    contentDescription = stringResource(id = R.string.rectangle1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(150.dp, 150.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.rectangle1),
                    contentDescription = stringResource(id = R.string.rectangle1),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(150.dp, 150.dp)

                )
            }
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onNextButtonClicked()
                },
                ) {
                Text(
                    text = stringResource(R.string.registration),
                    fontSize = 16.sp
                )
            }
        }
    }

}
