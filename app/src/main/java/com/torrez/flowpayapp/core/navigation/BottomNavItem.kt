package com.torrez.flowpayapp.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.String

sealed class BottomNavItem (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    data object Home : BottomNavItem(
        route = NavRoutes.HOME,
        title = "Inicio",
        icon = Icons.Default.Home
    )

    data object Reporte : BottomNavItem(
        route = NavRoutes.REPORTE,
        title = "Reportes",
        icon = Icons.Default.ContentPaste
    )

    data object UserPerfil : BottomNavItem(
        route = NavRoutes.PERFIL,
        title = "Perfil",
        icon = Icons.Default.Person
    )
}