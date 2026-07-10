package com.torrez.flowpayapp.core.navigation

object NavRoutes {
    const val HOME = "Home"
    const val REPORTE = "Reporte"
    const val PERFIL = "Perfil"
    const val INICIO = "Inicio"
    const val LOGIN = "Login"
    const val REGISTRO = "registro"
    const val TERMINOS = "terminos"
    const val RECUPERAR = "recuperar"
    fun getTitle(
        route: String?
    ): String {
        return when{
            route == INICIO ->
                "Splsh"
            route == LOGIN ->
                "Pantalla Login"
            route == HOME ->
                "Pantalla Home"
            route == REPORTE ->
                "Pantalla Reportes"
            route == PERFIL ->
                "Pantalla Perfil"
            route == REGISTRO ->
                "Pantalla Registro"
            route == TERMINOS ->
                "Pantalla terminos"
            route == RECUPERAR ->
                "Pantalla Recuperar Contraseña"
            else ->
                "Flow App GG"
        }
    }
}