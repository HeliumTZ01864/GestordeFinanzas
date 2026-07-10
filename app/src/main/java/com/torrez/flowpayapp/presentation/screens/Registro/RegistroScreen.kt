package com.torrez.flowpayapp.presentation.screens.Registro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.torrez.flowpayapp.di.AppContainer
import com.torrez.flowpayapp.presentation.components.UsuarioForm

@Composable
fun RegistroScreen(
    navController: NavController,
    vm: RegistroViewModel
){
    val uiState by vm.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if(uiState.isSuccess){
            vm.clearSuccess()

            navController.popBackStack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            ),

        verticalArrangement =
            Arrangement.spacedBy(12.dp)
    ){
        UsuarioForm(
            nombre = uiState.nombre,
            dni = uiState.dni,
            telefono = uiState.telefono,
            correo = uiState.correo,
            password = uiState.password,

            onNombreChange = vm::onNombreChange,
            onDniChange = vm::onDniChange,
            onTelefonoChange = vm::onTelefonoChange,
            onCorreoChange = vm::onCorreoChange,
            onPasswordChange = vm::onPasswordChange,

        )

        Spacer(
            modifier =
                Modifier.height(8.dp)
        )

        Button(
            modifier =
                Modifier.fillMaxWidth(),

            enabled =
                !uiState.isLoading,
            onClick = {
                vm.registro()
            }

        ) {

            if (uiState.isLoading) {

                CircularProgressIndicator()

            } else {

                Text("Guardar Usuario")
            }
        }
    }
}