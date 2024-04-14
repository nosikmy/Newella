package com.example.newella.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(): ViewModel()  {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    var userInputName by mutableStateOf("")
        private set


    var userInputPassword by mutableStateOf("")
        private set


    fun updateUserName(enteredName: String){
        userInputName = enteredName
    }


    fun updateUserPassword(enteredPassword: String){
        userInputPassword = enteredPassword
    }


    fun checkName() {
        if (userInputName.length < 2) {
            _uiState.update { currentState ->
                currentState.copy(enteredNameWrong = true)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(enteredNameWrong = false)
            }
        }
    }


    fun checkPassword() {
        if (userInputPassword.length > 5 &&
            userInputPassword.any{ it.isDigit() } &&
            userInputPassword.any { it.isUpperCase() } &&
            userInputPassword.none { it.isWhitespace() } &&
            userInputPassword.none { !it.isLetterOrDigit() }
        ) {
            _uiState.update { currentState ->
                currentState.copy(enteredPasswordWrong = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(enteredPasswordWrong = true)
            }
        }
    }

}