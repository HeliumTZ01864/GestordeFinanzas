package com.torrez.flowpayapp.presentation.screens.Registro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torrez.flowpayapp.core.utils.obtenerFechaActual
import com.torrez.flowpayapp.domain.usecase.UsuarioUseCases
import com.torrez.flowpayapp.presentation.event.EventBus
import com.torrez.flowpayapp.presentation.event.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegistroViewModel(    private val useCases: UsuarioUseCases) : ViewModel() {

    private val _uiState = MutableStateFlow(RegistroUiState())

    val uiState = _uiState.asStateFlow()

    fun onNombreChange(value: String
    ){
        _uiState.value =
            _uiState.value.copy(
                nombre = value
            )
    }

    fun onDniChange(value: String
    ){
        _uiState.value =
            _uiState.value.copy(
                dni = value
            )
    }

    fun onTelefonoChange(value: String
    ){
        _uiState.value =
            _uiState.value.copy(
                telefono = value
            )
    }

    fun onCorreoChange(value: String
    ){
        _uiState.value =
            _uiState.value.copy(
                correo = value
            )
    }

    fun onPasswordChange(value: String
    ){
        _uiState.value =
            _uiState.value.copy(
                password = value
            )
    }


    fun registro(){
        viewModelScope.launch {
            if(!validateForm()){
                return@launch
            }

            try {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                      )

                useCases.insertarUsuario(
                    _uiState.value.nombre,
                    _uiState.value.dni,
                    _uiState.value.telefono,
                    _uiState.value.correo,
                    _uiState.value.password,
                    obtenerFechaActual()
                )

                clearForm()

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        isSuccess = true
                    )
                EventBus.send(
                    UiEvent.Success(
                        "Usuario registrado con exito!"
                    )
                )
            } catch (e: Exception){
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        errorMessage = e.message
                    )

                EventBus.send(

                    UiEvent.Error(
                        "Error al registrar usuario"
                    )
                )
            }
        }
    }

    private suspend fun validateForm(): Boolean{
        when{
            _uiState.value.nombre.isBlank() ->{
                EventBus.send(
                    UiEvent.Warning(
                        "Ingrese el nombre"
                    )
                )
                return false
            }

            _uiState.value.dni.isBlank() ->{
                EventBus.send(
                    UiEvent.Warning(
                        "Ingrese el DNI"
                    )
                )
                return false
            }

            _uiState.value.telefono.isBlank() ->{
                EventBus.send(
                    UiEvent.Warning(
                        "Ingrese el Telefono"
                    )
                )
                return false
            }

            _uiState.value.correo.isBlank() ->{
                EventBus.send(
                    UiEvent.Warning(
                        "Ingrese el Correo"
                    )
                )
                return false
            }

            _uiState.value.password.isBlank() ->{
                EventBus.send(
                    UiEvent.Warning(
                        "Ingrese la contraseña"
                    )
                )
                return false
            }




        }
        return true
    }

    fun clearSuccess() {

        _uiState.value =
            _uiState.value.copy(
                isSuccess = false
            )
    }

    private fun clearForm() {
        _uiState.value =
            _uiState.value.copy(
                id="",
                nombre="",
                dni="",
                telefono="",
                correo="",
                password="",

            )
    }
}