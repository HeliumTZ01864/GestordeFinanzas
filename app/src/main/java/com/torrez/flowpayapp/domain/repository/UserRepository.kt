package com.torrez.flowpayapp.domain.repository

import com.torrez.flowpayapp.domain.model.User

interface UserRepository {

    suspend fun getUsers(): List<User>

    suspend fun getUserById(id: String): User

    suspend fun addUser(
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String
    )

    suspend fun updateUser(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String
    )

    suspend fun deleteUser(id: String)
}