package com.torrez.flowpayapp.presentation.screens.Registro

data class RegistroUiState(
    val id: String = "",
    val nombre: String = "",
    val dni: String = "",
    val telefono: String = "",
    val correo: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)
