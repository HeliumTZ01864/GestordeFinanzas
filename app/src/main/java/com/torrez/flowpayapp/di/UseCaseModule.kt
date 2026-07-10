package com.torrez.flowpayapp.di

import com.torrez.flowpayapp.domain.usecase.ActualizarUsuarioUseCase
import com.torrez.flowpayapp.domain.usecase.EliminarUsuarioUseCase
import com.torrez.flowpayapp.domain.usecase.GetUsuarioByIdUseCase
import com.torrez.flowpayapp.domain.usecase.GetUsuarioUseCase
import com.torrez.flowpayapp.domain.usecase.InsertarUsuarioUseCase
import com.torrez.flowpayapp.domain.usecase.LoginUsuarioUseCase
import com.torrez.flowpayapp.domain.usecase.UsuarioUseCases

class UseCaseModule(repositoryModule: RepositoryModule) {

    val usuarioUseCaseModule by lazy {
        UsuarioUseCases(
            getUsuarios = GetUsuarioUseCase(repositoryModule.usuarioRepository),
            insertarUsuario = InsertarUsuarioUseCase(repositoryModule.usuarioRepository),
            eliminarUsuario = EliminarUsuarioUseCase(repositoryModule.usuarioRepository),
            getUsuarioById = GetUsuarioByIdUseCase(repositoryModule.usuarioRepository),
            actualizarUsuario = ActualizarUsuarioUseCase(repositoryModule.usuarioRepository),
            loginUsuario = LoginUsuarioUseCase(repositoryModule.usuarioRepository)
        )
    }
}