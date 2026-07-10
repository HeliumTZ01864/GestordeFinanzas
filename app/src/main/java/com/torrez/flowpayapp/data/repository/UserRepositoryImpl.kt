package com.torrez.flowpayapp.data.repository

import com.torrez.flowpayapp.data.mapper.toDomain
import com.torrez.flowpayapp.data.remote.datasource.RemoteDataSource
import com.torrez.flowpayapp.data.remote.dto.CreateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UpdateUserRequest

import com.torrez.flowpayapp.domain.model.Usuario
import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class UserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : UsuarioRepository {

    override suspend fun getUsuarios(): List<Usuario> {
        return remoteDataSource.getUsers()
            ?.data
            ?.items
            ?.map { it.toDomain()
            }
            ?:emptyList()
    }

    override suspend fun getUsuarioById(id: String): Usuario {
        return remoteDataSource
            .getUserById(id)?.toDomain() ?: throw Exception("Usuario no encontrado")
    }

    override suspend fun addUsuario(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String
    ) {
        remoteDataSource.createUser(CreateUserRequest( nombre, dni, telefono
            , correo,  password, ""))
    }

    override suspend fun updateUsuario(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String
    ) {
        remoteDataSource.updateUser(
            id,
            UpdateUserRequest(nombre, dni, telefono, correo, password,
                 ""))
    }

    override suspend fun deleteUsuario(id: String) {
        remoteDataSource.deleteUser(id)
    }

    suspend fun getAll(): List<Usuario> =
        remoteDataSource.getUsers()
            ?.data
            ?.items
            ?.map { it.toDomain() }
            ?: emptyList()

    override suspend fun login(
        mail: String,
        psw: String
    ): Usuario? {
        return getAll().firstOrNull { it.correo == mail && it.password == psw }
    }
}