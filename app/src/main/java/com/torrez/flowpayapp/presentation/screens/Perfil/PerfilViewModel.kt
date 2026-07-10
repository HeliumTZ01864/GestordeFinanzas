package com.torrez.flowpayapp.presentation.screens.Perfil

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

class PerfilViewModel (
    private val useCases: UsuarioUseCases
): ViewModel(){
    private val _uiState =
        MutableStateFlow(
            PerfilUiState()
        )

    val uiState =
        _uiState.asStateFlow()

    private val _event =
        MutableSharedFlow<String>()

    val event =
        _event.asSharedFlow()

    fun loadUsuario(
        id: String
    ) {
        viewModelScope.launch {
            try {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )
                val usuario =
                    useCases.getUsuarioById(id)

                _uiState.value =
                    _uiState.value.copy(
                        usuario = usuario,
                        isLoading = false
                    )
            }catch (e : Exception){
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        errorMessage = e.message
                    )

                _event.emit(
                    e.message
                        ?: "Error al cargar libro"
                )
            }
        }
    }

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

    fun clearError() {
        _uiState.value =
            _uiState.value.copy(
                errorMessage = null
            )
    }
}