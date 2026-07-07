package com.torrez.flowpayapp.domain.model

data class User(
    val id: String,
    val nombre: String,
    val dni: String,
    val telefono: String,
    val correo: String,
    val password: String,
    val fecharegistro: String
)
