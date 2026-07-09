package com.torrez.flowpayapp.di

class ViewModelModule(private val useCaseModule: UseCaseModule) {

    fun provideHomeViewModel(): HomeViewModel {
        return HomeViewModel(useCaseModule.usuarioUseCaseModule)
    }

    fun provideAddUserViewModel(): AddUserViewModel {
        return AddUserViewModel(
            useCaseModule.usuarioUseCaseModule
        )
    }

    fun provideEditUserViewModel(): EditUserViewModel {
        return EditUserViewModel(
            useCaseModule.usuarioUseCaseModule
        )
    }
}