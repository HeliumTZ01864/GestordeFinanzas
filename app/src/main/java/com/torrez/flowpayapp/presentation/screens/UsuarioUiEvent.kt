package com.torrez.flowpayapp.presentation.screens

sealed class UsuarioUiEvent {
    data class MostrarSnackbar(val mensaje: String) : UsuarioUiEvent()
    object NavegateToLogin : UsuarioUiEvent()
    object LoginSuccess : UsuarioUiEvent()
}