package com.torrez.flowpayapp.data.remote.dto

data class CreateUserRequest(
    val nombre: String,
    val dni: String,
    val telefono: String,
    val correo: String,
    val password: String,
    val fecharegistro: String
)
