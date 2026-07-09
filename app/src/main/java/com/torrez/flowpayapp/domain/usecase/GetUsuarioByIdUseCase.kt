package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.model.Usuario
import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class GetUsuarioByIdUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke(
        id: String
    ): Usuario {

        return repository.getUsuarioById(id)
    }
}