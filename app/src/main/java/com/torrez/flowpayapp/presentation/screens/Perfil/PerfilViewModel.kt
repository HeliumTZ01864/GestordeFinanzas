package com.torrez.flowpayapp.presentation.screens.Perfil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torrez.flowpayapp.core.session.SessionManager
import com.torrez.flowpayapp.domain.usecase.UsuarioUseCases
import com.torrez.flowpayapp.presentation.screens.UsuarioUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PerfilViewModel (
    private val useCases: UsuarioUseCases,
    private val sessionManager: SessionManager
): ViewModel(){
    private val _uiState =
        MutableStateFlow(PerfilUiState())

    val uiState =
        _uiState.asStateFlow()

    init {
        observarSesion()
    }

    private fun observarSesion() {

        viewModelScope.launch {

            sessionManager.usuarioActual.collect { usuario ->

                _uiState.update {
                    it.copy(
                        usuario = usuario,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun actualizarDatosUsuario() {

        val usuarioActual = uiState.value.usuario ?: return

        viewModelScope.launch {

            try {

                _uiState.update {
                    it.copy(
                        isLoading = true,
                        errorMessage = null
                    )
                }

                val usuarioActualizado = useCases.getUsuarioById(
                    usuarioActual.id
                )

                if (usuarioActualizado != null) {

                    sessionManager.iniciarSesion(
                        usuarioActualizado
                    )
                }

                _uiState.update {
                    it.copy(
                        isLoading = false
                    )
                }

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message
                            ?: "Error al cargar el perfil"
                    )
                }
            }
        }
    }

    fun cerrarSesion() {
        sessionManager.cerrarSesion()
    }

    fun clearError() {

        _uiState.update {
            it.copy(
                errorMessage = null
            )
        }
    }
}