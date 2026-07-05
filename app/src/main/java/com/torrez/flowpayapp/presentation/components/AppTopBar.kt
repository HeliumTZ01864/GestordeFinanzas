package com.torrez.flowpayapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(

    navController:
    NavHostController

) {

    val navBackStackEntry = navController.currentBackStackEntryAsState()

    val route =navBackStackEntry
                .value
                ?.destination
                ?.route

    val title = NavRoutes.getTitle(route)

    val showBackButton =  route != NavRoutes.HOME

    CenterAlignedTopAppBar(

        title = {

            Text(title, style = MaterialTheme.typography.titleLarge)
        },

        navigationIcon = {

            if (showBackButton) {

                IconButton(

                    onClick = {

                        navController
                            .popBackStack()
                    }

                ) {

                    Icon(
                        imageVector =
                            Icons.AutoMirrored.Filled.ArrowBack,

                        contentDescription =
                            "Volver"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}