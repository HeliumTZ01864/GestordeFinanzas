package com.torrez.flowpayapp.di

import com.torrez.flowpayapp.presentation.screens.Registro.RegistroViewModel

class ViewModelModule(private val useCaseModule: UseCaseModule) {
/*
    fun provideHomeViewModel(): HomeViewModel {
        return HomeViewModel(useCaseModule.usuarioUseCaseModule)
    }



    fun provideEditUserViewModel(): EditUserViewModel {
        return EditUserViewModel(
            useCaseModule.usuarioUseCaseModule
        )
    }*/

    fun provideAddUserViewModel(): RegistroViewModel {
        return RegistroViewModel(
            useCaseModule.usuarioUseCaseModule
        )
    }
}