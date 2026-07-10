package com.torrez.flowpayapp.domain.usecase

data class UsuarioUseCases(

    val getUsuarios: GetUsuarioUseCase,
    val getUsuarioById: GetUsuarioByIdUseCase,
    val insertarUsuario: InsertarUsuarioUseCase,
    val actualizarUsuario: ActualizarUsuarioUseCase,
    val eliminarUsuario: EliminarUsuarioUseCase,
    val loginUsuario: LoginUsuarioUseCase
)