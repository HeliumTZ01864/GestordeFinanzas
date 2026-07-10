package com.torrez.flowpayapp.di

import com.torrez.flowpayapp.presentation.screens.Login.LoginViewModel
import com.torrez.flowpayapp.presentation.screens.Perfil.PerfilViewModel
import com.torrez.flowpayapp.presentation.screens.Registro.RegistroViewModel

class AppContainer {
    private val networkModule by lazy {
        NetworkModule()
    }

    private val repositoryModule by lazy {
        RepositoryModule(networkModule)
    }

    // Que se llamae igual
    private val useCaseModule by lazy {
        UseCaseModule(repositoryModule)
    }

    /*val viewModelModule by lazy {
        ViewModelModule(
            useCaseModule
        )
    }*/

    val homeViewModel by lazy {
        //HomeViewModel(useCaseModule.usuarioUseCaseModule)
    }

    val addUserViewModel by lazy {
        RegistroViewModel(useCaseModule.usuarioUseCaseModule)
    }

    val editUserViewModel by lazy {
        //EditUserViewModel(useCaseModule.usuarioUseCaseModule)
    }
    val perfilModelModule by lazy {
        PerfilViewModel(useCaseModule.usuarioUseCaseModule)
    }

    val loginModelModule by lazy {
        LoginViewModel(useCaseModule.usuarioUseCaseModule)
    }
}