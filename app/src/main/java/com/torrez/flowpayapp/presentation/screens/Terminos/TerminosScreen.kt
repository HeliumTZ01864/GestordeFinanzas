package com.torrez.flowpayapp.presentation.screens.Terminos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TerminosScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FlowPay") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Términos de Uso y Políticas de Privacidad - FlowPay",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = """ 
                1. Introducción
                Bienvenido a FlowPay. Al utilizar esta aplicación, aceptas los siguientes términos y condiciones, así como nuestras políticas de privacidad. Si no estás de acuerdo con alguno de estos puntos, te recomendamos no utilizar la aplicación.
                
                2. Uso de la Aplicación
                FlowPay es una herramienta diseñada para ayudarte a gestionar tus finanzas personales. El usuario se compromete a:
                Proporcionar información veraz y actualizada.
                Utilizar la aplicación únicamente con fines personales y legales.
                No realizar actividades que puedan afectar el funcionamiento de la app.
                Nos reservamos el derecho de suspender cuentas que incumplan estas condiciones.
                
                3. Datos que Recopilamos
                Para ofrecer un mejor servicio, FlowPay puede recopilar:
                Información personal básica (nombre, correo electrónico).
                Datos financieros ingresados por el usuario (ingresos, gastos, categorías).
                Información técnica (tipo de dispositivo, sistema operativo, uso de la app).
                
                4. Uso de la Información
                Los datos recopilados se utilizan para:
                Mejorar la experiencia del usuario.
                Personalizar funcionalidades.
                Garantizar la seguridad de la aplicación.
                Enviar notificaciones importantes relacionadas con el servicio.
                No vendemos ni compartimos tu información personal con terceros sin tu consentimiento, salvo obligación legal.
                
                5. Seguridad de la Información
                Implementamos medidas de seguridad para proteger tus datos. Sin embargo, ningún sistema es completamente seguro, por lo que no podemos garantizar seguridad absoluta.
                
                6. Privacidad del Usuario
                Tus datos financieros son privados y solo tú tienes acceso a ellos.
                Puedes solicitar la eliminación de tu cuenta y datos en cualquier momento.
                No accedemos a tu información sin tu autorización.
                
                7. Cambios en los Términos
                Nos reservamos el derecho de modificar estos términos en cualquier momento. Se notificará a los usuarios sobre cambios relevantes.
                
                8. Responsabilidad
                MoneyTrack no se hace responsable por:
                Decisiones financieras tomadas por el usuario.
                Pérdidas económicas derivadas del uso de la app.
                Errores en el ingreso de datos por parte del usuario.
                
                9. Contacto
                Si tienes dudas sobre estos términos o la política de privacidad, puedes contactarnos a través del correo: soporte@moneytrack.com
                
                Fecha de última actualización: 29/03/2026       
                """.trimIndent()
            )
        }
    }
}