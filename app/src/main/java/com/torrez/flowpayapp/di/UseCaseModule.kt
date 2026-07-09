package com.torrez.flowpayapp.di

class UseCaseModule(repositoryModule: RepositoryModule) {

    val usuarioUseCaseModule by lazy {
        UsuarioUseCases(
            getUsuarios = GetUsuariosUseCase(repositoryModule.usuarioRepository),
            addUsuario = AddUsuarioUseCase(repositoryModule.usuarioRepository),
            deleteUsuario = DeleteUsuarioUseCase(repositoryModule.usuarioRepository),
            getUsuarioById = GetUsuarioByIdUseCase(repositoryModule.usuarioRepository),
            updateUsuario = UpdateUsuarioUseCase(repositoryModule.usuarioRepository)
        )
    }
}