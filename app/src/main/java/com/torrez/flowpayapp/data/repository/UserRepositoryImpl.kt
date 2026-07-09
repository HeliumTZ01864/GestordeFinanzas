package com.torrez.flowpayapp.data.repository

import com.torrez.flowpayapp.data.mapper.toDomain
import com.torrez.flowpayapp.data.remote.datasource.RemoteDataSource
import com.torrez.flowpayapp.data.remote.dto.CreateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UpdateUserRequest
import com.torrez.flowpayapp.domain.model.User
import com.torrez.flowpayapp.domain.repository.UserRepository

class UserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return remoteDataSource
            .getUsers()
            .items
            .map { it.toDomain() }
    }

    override suspend fun getUserById(id: String): User {
        return remoteDataSource
            .getUserById(id)
            .data
            .toDomain()
    }

    override suspend fun addUser(
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String
    ) {
        remoteDataSource.createUser(CreateUserRequest(nombre = nombre, dni = dni,telefono = telefono
            ,correo = correo, password = password, fecharegistro = ""))
    }

    override suspend fun updateUser(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String
    ) {
        remoteDataSource.updateUser(
            id,
            UpdateUserRequest(nombre = nombre,dni = dni,telefono = telefono,correo = correo,password = password,
                fecharegistro = ""))
    }

    override suspend fun deleteUser(id: String) {
        remoteDataSource.deleteUser(id)
    }
}