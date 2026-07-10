package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class ActualizarUsuarioUseCase(
    private val repository: UsuarioRepository)
{
    suspend operator fun invoke(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String,
    )

    {
        // Mantenemos tus validaciones de negocio adaptadas al nuevo formato de parámetros planos
        if (id.isBlank()) throw Exception("ID inválido")
        if (nombre.isBlank()) throw Exception("Nombre del usuario vacio")
        if (correo.isBlank()) throw Exception("E-mail vacio")
        if (password.isBlank()) throw Exception("Contraseña vacio")

        // Invocamos el método del nuevo repositorio
        repository.updateUsuario(
            id = id,
            nombre=nombre,
            dni=dni,
            telefono=telefono,
            correo=correo,
            password=password,
            fecharegistro=fecharegistro
        )
    }
}