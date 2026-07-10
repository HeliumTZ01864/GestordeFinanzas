package com.torrez.flowpayapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun UsuarioForm(
    nombre: String,
    dni: String,
    telefono: String,
    correo: String,
    password: String,
    onNombreChange: (String) -> Unit,
    onDniChange: (String) -> Unit,
    onTelefonoChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,

){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedTextField(
            value = nombre,
            onValueChange = onNombreChange,
            label = {
                Text("Nombre")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dni,
            onValueChange = {
                if (it.all(Char::isDigit)) {
                    onDniChange(it)
                }
            },
            label = {
                Text("DNI")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = {
                if (it.all(Char::isDigit)) {
                    onTelefonoChange(it)
                }
            },
            label = {
                Text("Teléfono")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = onCorreoChange,
            label = {
                Text("Correo")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = {
                Text("Contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )
    }
}