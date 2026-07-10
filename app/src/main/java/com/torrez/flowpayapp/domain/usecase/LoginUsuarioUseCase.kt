package com.torrez.flowpayapp.domain.usecase

import com.torrez.flowpayapp.domain.model.Usuario
import com.torrez.flowpayapp.domain.repository.UsuarioRepository

class LoginUsuarioUseCase (private val repo: UsuarioRepository){
    suspend operator fun invoke(mail: String, psw: String): Usuario?
    {
        if (mail.isBlank()) throw Exception("Ingrese correo")
        if (psw.isBlank()) throw Exception("Ingrese contraseña")

        return repo.login(mail, psw)
    }
}