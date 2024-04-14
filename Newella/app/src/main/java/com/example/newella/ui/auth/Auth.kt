package com.example.newella.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.newella.ui.theme.NewellaTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.example.newella.R
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun AuthScreen(
    authViewModel: AuthViewModel = viewModel(),
    onToRegistrationClick: () -> Unit,
) {
    val authUiState by authViewModel.uiState.collectAsState()


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        inputField(authViewModel, authUiState)

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
            },
        ) {
            Text(
                text = stringResource(R.string.auth),
                fontSize = 16.sp
            )
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onToRegistrationClick()
            },
        ) {
            Text(
                text = stringResource(R.string.to_reg),
                fontSize = 16.sp
            )
        }
    }

}

@Composable
fun inputField(
    authViewModel: AuthViewModel,
    authUiState: AuthUiState
){
    Column(
    ) {
        //Name
        OutlinedTextField(
            value = authViewModel.userInputName,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { authViewModel.updateUserName(it) },
            label = {
                if (authUiState.enteredNameWrong) {
                    Text(stringResource(R.string.wrong_name))
                } else {
                    Text(stringResource(R.string.enter_name))
                }
            },
            isError = authUiState.enteredNameWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    authViewModel.checkName()
                }
            )
        )

        //Password
        OutlinedTextField(
            value = authViewModel.userInputPassword,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { authViewModel.updateUserPassword(it) },
            label = {
                if (authUiState.enteredPasswordWrong) {
                    Text(stringResource(R.string.wrong_password))
                } else {
                    Text(stringResource(R.string.enter_password))
                }
            },
            isError = authUiState.enteredPasswordWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    authViewModel.checkPassword()
                }
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    NewellaTheme {
        //AuthScreen()
    }
}