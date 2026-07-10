package com.torrez.flowpayapp.core.session

import com.torrez.flowpayapp.domain.model.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionManager {
    private val _usuarioActual = MutableStateFlow<Usuario?>(null)

    val usuarioActual = _usuarioActual.asStateFlow()

    fun iniciarSesion(usuario: Usuario) {
        _usuarioActual.value = usuario
    }

    fun cerrarSesion() {
        _usuarioActual.value = null
    }

    fun haySesionActiva(): Boolean {
        return _usuarioActual.value != null
    }
}