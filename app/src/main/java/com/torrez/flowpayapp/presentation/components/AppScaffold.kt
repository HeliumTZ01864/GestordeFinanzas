package com.torrez.flowpayapp.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.torrez.flowpayapp.presentation.event.EventBus
import com.torrez.flowpayapp.presentation.event.UiEvent

@Composable
fun AppScaffold(
    navController: NavHostController,

    content: @Composable (
        PaddingValues
    ) -> Unit

) {

    val snackbarHostState =
        remember {
            SnackbarHostState()
        }

    LaunchedEffect(Unit) {

        EventBus.events.collect { event ->

            when(event) {

                is UiEvent.Success -> {

                    snackbarHostState
                        .showSnackbar(
                            event.message
                        )
                }

                is UiEvent.Error -> {

                    snackbarHostState
                        .showSnackbar(
                            event.message
                        )
                }

                is UiEvent.Warning -> {

                    snackbarHostState
                        .showSnackbar(
                            event.message
                        )
                }
            }
        }
    }

    Scaffold(

        topBar = {

            AppTopBar(
                navController
            )
        },

        bottomBar = {

            AppBottomBar(
                navController
            )
        },

        snackbarHost = {

            SnackbarHost(
                snackbarHostState
            )
        }

    ) { padding ->

        content(padding)
    }
}