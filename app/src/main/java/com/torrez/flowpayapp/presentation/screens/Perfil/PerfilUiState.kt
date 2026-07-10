package com.torrez.flowpayapp.presentation.screens.Perfil

import com.torrez.flowpayapp.domain.model.Usuario

data class PerfilUiState(
    val usuario: Usuario? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val usuarioLogueado: Usuario? = null,
)
