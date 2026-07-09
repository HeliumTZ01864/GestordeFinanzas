package com.torrez.flowpayapp.di

import com.torrez.flowpayapp.data.remote.datasource.RemoteDataSource
import com.torrez.flowpayapp.data.repository.UserRepositoryImpl
import com.torrez.flowpayapp.domain.repository.UsuarioRepository
import kotlin.getValue

class RepositoryModule(networkModule: NetworkModule) {

    private val remoteDataSource by lazy {
        RemoteDataSource(networkModule.apiService)
    }

    val usuarioRepository: UsuarioRepository by lazy {
        UserRepositoryImpl(remoteDataSource)
    }
}