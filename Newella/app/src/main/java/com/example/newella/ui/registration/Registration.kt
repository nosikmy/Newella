package com.example.newella.ui.registration

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
import com.example.newella.ui.theme.seed


@Composable
fun RegistrationScreen(
    onToAuthClick: () -> Unit,
    registrationViewModel: RegistrationViewModel = viewModel(),
) {
    val registrationUiState by registrationViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Newella",
            style = MaterialTheme.typography.titleMedium,
            color = seed
        )

        inputField(registrationViewModel, registrationUiState)

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
            },
        ) {
            Text(
                text = stringResource(R.string.registration),
                fontSize = 16.sp
            )
        }

        TextButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onToAuthClick()
            },
        ) {
            Text(
                text = stringResource(R.string.to_auth),
                fontSize = 16.sp
            )
        }

    }

}

@Composable
fun inputField(
    registrationViewModel: RegistrationViewModel,
    registrationUiState: RegistrationUiState
) {
    Column(
    ) {
        //Name
        OutlinedTextField(
            value = registrationViewModel.userInputName,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { registrationViewModel.updateUserName(it) },
            label = {
                if (registrationUiState.enteredNameWrong) {
                    Text(stringResource(R.string.wrong_name))
                } else {
                    Text(stringResource(R.string.enter_name))
                }
            },
            isError = registrationUiState.enteredNameWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    registrationViewModel.checkName()
                }
            )
        )
        //Email
        OutlinedTextField(
            value = registrationViewModel.userInputEmail,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { registrationViewModel.updateUserEmail(it) },
            label = {
                if (registrationUiState.enteredEmailWrong) {
                    Text(stringResource(R.string.wrong_emeil))
                } else {
                    Text(stringResource(R.string.enter_email))
                }
            },
            isError = registrationUiState.enteredEmailWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    registrationViewModel.checkEmail()
                }
            )
        )
        //Password
        OutlinedTextField(
            value = registrationViewModel.userInputPassword,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { registrationViewModel.updateUserPassword(it) },
            label = {
                if (registrationUiState.enteredPasswordWrong) {
                    Text(stringResource(R.string.wrong_password))
                } else {
                    Text(stringResource(R.string.enter_password))
                }
            },
            isError = registrationUiState.enteredPasswordWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    registrationViewModel.checkPassword()
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