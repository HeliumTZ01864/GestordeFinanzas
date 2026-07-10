package com.torrez.flowpayapp.presentation.screens.Registro

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.torrez.flowpayapp.core.navigation.NavRoutes
import com.torrez.flowpayapp.di.AppContainer
import com.torrez.flowpayapp.presentation.components.UsuarioForm

@Composable
fun RegistroScreen(
    navController: NavController,
    vm: RegistroViewModel
){
    val uiState by vm.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isSuccess) {
        if(uiState.isSuccess){
            vm.clearSuccess()

            navController.popBackStack()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),

                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Registro",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Todos los datos están protegidos"
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

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

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Al continuar, aceptas nuestros Términos de uso y Política de privacidad",
                    color = Color.Cyan,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        navController.navigate(NavRoutes.TERMINOS)
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

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

                        Text("Registrar Usuario")
                    }
                }
            }
        }
    }


}