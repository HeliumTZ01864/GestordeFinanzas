package com.torrez.flowpayapp.di

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
        //AddUserViewModel(useCaseModule.usuarioUseCaseModule)
    }

    val editUserViewModel by lazy {
        //EditUserViewModel(useCaseModule.usuarioUseCaseModule)
    }
}