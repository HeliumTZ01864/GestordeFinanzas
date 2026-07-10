package com.torrez.flowpayapp.presentation.screens.Login

import com.torrez.flowpayapp.domain.model.Usuario

data class LoginUiState(
    val usuario: Usuario? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val usuarioLogueado: Usuario? = null,
)
