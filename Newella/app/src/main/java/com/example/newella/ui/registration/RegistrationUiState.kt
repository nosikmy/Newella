package com.example.newella.ui.registration

data class RegistrationUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",

    val enteredNameWrong: Boolean = false,
    val enteredEmailWrong: Boolean = false,
    val enteredPasswordWrong: Boolean = false,
    )
