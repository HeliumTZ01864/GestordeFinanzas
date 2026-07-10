package com.torrez.flowpayapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DataExploration
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.torrez.flowpayapp.core.navigation.NavRoutes

@Composable
fun AppBottomBar(navController: NavController){
    NavigationBar{
        //Home
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(
                    NavRoutes.HOME
                )
            },

            icon = {
                Icon(
                    Icons.Default.Home,
                    null
                )
            },

            label = {
                Text("Inicio")
            }
        )
        //Reportes
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(
                    NavRoutes.REPORTE
                )
            },

            icon = {
                Icon(
                    Icons.Default.DataExploration,
                    null
                )
            },

            label = {
                Text("Reporte")
            }
        )
        //Perfil
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(
                    NavRoutes.PERFIL
                )
            },

            icon = {
                Icon(
                    Icons.Default.AccountCircle,
                    null
                )
            },

            label = {
                Text("Perfil")
            }
        )
    }
}