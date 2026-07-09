package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class GetUsuarioUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke() =
        repository.getUsuarios()
}