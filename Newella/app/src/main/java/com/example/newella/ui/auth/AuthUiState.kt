package com.example.newella.ui.auth

data class AuthUiState(
    val name: String = "",
    val password: String = "",

    val enteredNameWrong: Boolean = false,
    val enteredPasswordWrong: Boolean = false,
    )
