package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class InsertarUsuarioUseCase(
    private val repository: UsuarioRepository
) {

    suspend operator fun invoke(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String,
    ) {
        if (nombre.isBlank()) throw Exception("Nombre vacío")
        if (correo.isBlank()) throw Exception("Correo vacío")
        if (password.isBlank()) throw Exception("Contraseña vacía")

        repository.addUsuario(
            id,
            nombre,
            dni,
            telefono,
            correo,
            password,
            fecharegistro
        )
    }
}