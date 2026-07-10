package com.torrez.flowpayapp.presentation.screens.Perfil

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(
    vm: PerfilViewModel,
    navController: NavController
){
    val uiState by vm.uiState.collectAsState()
    val usuario = uiState.usuarioLogueado

    if (usuario == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { Text("No hay una sesión iniciada") }
        return
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Perfil",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF212020),
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                ),

                modifier = Modifier.clip(
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
            )
        },

        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("home")
                    },
                    icon = {
                        Icon(Icons.Default.Home, null)
                    },
                    label = {
                        Text("Inicio")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("reportes")
                    },
                    icon = {
                        Icon(Icons.AutoMirrored.Filled.ShowChart, null)
                    },
                    label = {
                        Text("Reportes")
                    }
                )

                NavigationBarItem(
                    selected = true,
                    onClick = {
                        navController.navigate("perfil")
                    },
                    icon = {
                        Icon(Icons.Default.Person, null)
                    },
                    label = {
                        Text("Perfil")
                    }
                )
            }

        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(18.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(140.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                FloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(42.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar perfil"
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            com.torrez.flowpayapp.presentation.screens.Perfil.PerfilItem(
                icon = Icons.Default.Person,
                titulo = "Nombre",
                valor = usuario.nombre
            )

            com.torrez.flowpayapp.presentation.screens.Perfil.PerfilItem(
                icon = Icons.Default.Badge,
                titulo = "Documento",
                valor = usuario.dni
            )

            com.torrez.flowpayapp.presentation.screens.Perfil.PerfilItem(
                icon = Icons.Default.Phone,
                titulo = "Celular",
                valor = usuario.telefono
            )

            com.torrez.flowpayapp.presentation.screens.Perfil.PerfilItem(
                icon = Icons.Default.Email,
                titulo = "Correo electrónico",
                valor = usuario.correo
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Red
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF121212),
                    contentColor = Color.Red
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = null,
                    tint = Color.Red
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text("Cerrar sesión")
            }
        }
    }
}


@Composable
fun PerfilItem(
    icon: ImageVector,
    titulo: String,
    valor: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(
                    text = titulo,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )

                Text(
                    text = valor,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}