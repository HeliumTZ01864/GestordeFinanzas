package com.torrez.flowpayapp.presentation.screens.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.torrez.flowpayapp.core.navigation.NavRoutes
import com.torrez.flowpayapp.presentation.screens.UsuarioUiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    vm: LoginViewModel,
    navController: NavController
) {

    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val uiState by vm.uiState.collectAsState()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {

        vm.event.collect { event ->

            when (event) {

                is UsuarioUiEvent.MostrarSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.mensaje
                    )
                }

                is UsuarioUiEvent.LoginSuccess -> {
                    navController.navigate(NavRoutes.HOME){
                        popUpTo(NavRoutes.LOGIN) {
                            inclusive = true
                        }
                    }
                }

                else -> {}
            }
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 36.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(
                    modifier = Modifier.height(60.dp)
                )

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "FlowPay",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.offset(
                            x = 2.dp,
                            y = 2.dp
                        )
                    )

                    Text(
                        text = "FlowPay",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF494949),
                                    Color(0xFFD4D4D4)
                                )
                            )
                        )
                    )
                }

                Text(
                    text = "Bienvenido al inicio de sesión"
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                OutlinedTextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("Correo") },
                    enabled = !uiState.isLoading,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    enabled = !uiState.isLoading,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    TextButton(
                        onClick = {
                            navController.navigate(NavRoutes.REGISTRO)
                        }
                    ) {
                        Text("Registrarse")
                    }

                    TextButton(
                        onClick = {
                            navController.navigate(NavRoutes.RECUPERAR)
                        }
                    ) {
                        Text("Recuperar contraseña")
                    }
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    onClick = {
                        vm.login(
                            correo,
                            password
                        )
                    },
                    enabled = !uiState.isLoading,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {

                    if (uiState.isLoading) {

                        CircularProgressIndicator(
                            modifier = Modifier.size(22.dp),
                            strokeWidth = 2.dp,
                            color = Color.White
                        )

                    } else {

                        Text("Iniciar Sesión")
                    }
                }
            }
        }
    }
}
