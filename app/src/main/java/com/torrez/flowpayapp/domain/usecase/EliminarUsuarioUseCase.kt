package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class EliminarUsuarioUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke(id: String) {
        if (id.isBlank()) throw Exception("Usuario inválido para eliminar")

        repository.deleteUsuario(id)
    }
}