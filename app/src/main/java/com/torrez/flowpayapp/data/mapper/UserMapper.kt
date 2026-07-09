package com.torrez.flowpayapp.data.mapper

import com.torrez.flowpayapp.data.remote.dto.UserDto

import com.torrez.flowpayapp.domain.model.Usuario


fun UserDto.toDomain(): Usuario {

    return Usuario(
        id = id,
        nombre = nombre,
        dni = dni,
        telefono = telefono,
        correo = correo,
        password = password,
        fecharegistro = fecharegistro
    )
}