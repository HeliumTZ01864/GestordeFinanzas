package com.torrez.flowpayapp.presentation.screens.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torrez.flowpayapp.domain.usecase.UsuarioUseCases
import com.torrez.flowpayapp.presentation.screens.UsuarioUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel (
    private val useCases: UsuarioUseCases
): ViewModel(){
    private val _uiState =
        MutableStateFlow(
            LoginUiState()
        )

    val uiState =
        _uiState.asStateFlow()

    private val _event =
        MutableSharedFlow<String>()

    val event =
        _event.asSharedFlow()

    fun login(mail: String, psw: String) {
        viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(isLoading = true)
                }
                val usuario = useCases.loginUsuario(mail, psw)

                if (usuario != null) {
                    _uiState.update {
                        it.copy(
                            usuarioLogueado = usuario
                        )
                    }
                    _event.emit(UsuarioUiEvent.LoginSuccess.toString())
                } else {
                    _event.emit(UsuarioUiEvent.MostrarSnackbar("Correo o contraseña incorrectos").toString())
                }
            } catch (e: Exception) {
                _event.emit(UsuarioUiEvent.MostrarSnackbar(e.message ?: "Error al iniciar sesión").toString())
            } finally {
                _uiState.update {
                    it.copy(isLoading = false)
                }
            }
        }
    }
}