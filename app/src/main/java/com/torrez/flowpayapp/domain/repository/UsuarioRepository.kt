package com.torrez.flowpayapp.domain.repository

import com.torrez.flowpayapp.domain.model.Usuario

interface UsuarioRepository {

    suspend fun getUsuarios(): List<Usuario>

    suspend fun getUsuarioById(id: String): Usuario

    suspend fun addUsuario(
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String
    )

    suspend fun updateUsuario(
        id: String,
        nombre: String,
        dni: String,
        telefono: String,
        correo: String,
        password: String,
        fecharegistro: String
    )


    suspend fun deleteUsuario(id: String)

    suspend fun login(mail: String, psw: String): Usuario?
}