package com.torrez.flowpayapp.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.torrez.flowpayapp.di.AppContainer
import com.torrez.flowpayapp.presentation.screens.Home.HomeScreen
import com.torrez.flowpayapp.presentation.screens.Inicio.InicialScreen
import com.torrez.flowpayapp.presentation.screens.Login.LoginScreen
import com.torrez.flowpayapp.presentation.screens.Perfil.PerfilScreen
import com.torrez.flowpayapp.presentation.screens.Registro.RegistroScreen
import com.torrez.flowpayapp.presentation.screens.Reportes.ReportesScreen

@Composable
fun AppNavigation(
    navController:NavHostController,
    container: AppContainer,
    padding:PaddingValues
){
    NavHost(
        navController = navController,
        startDestination = NavRoutes.INICIO,
        modifier = Modifier.padding(padding)
    ){
        composable (NavRoutes.INICIO){
            InicialScreen(onStartClick = { navController.navigate(NavRoutes.LOGIN)})
        }
        composable (NavRoutes.LOGIN){
            LoginScreen(vm = container.loginModelModule, navController)
        }
        composable (NavRoutes.HOME){
            HomeScreen()
        }
        composable (NavRoutes.REPORTE){
            ReportesScreen(navController)
        }
        composable (NavRoutes.PERFIL){
            PerfilScreen(vm = container.perfilModelModule, navController)
        }
        composable (NavRoutes.REGISTRO){
            RegistroScreen(navController,container.addUserViewModel)
        }

    }
}