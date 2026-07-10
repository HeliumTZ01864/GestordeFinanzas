package com.torrez.flowpayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.torrez.flowpayapp.core.navigation.AppNavigation
import com.torrez.flowpayapp.presentation.components.AppScaffold
import com.torrez.flowpayapp.ui.theme.FlowPayAppTheme

class MainActivity : ComponentActivity() {
    private val container by lazy {
        (application as FlowAplication).container
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowPayAppTheme {
                val navController =
                    rememberNavController()

                AppScaffold(

                    navController =
                        navController

                ) { padding ->

                    AppNavigation(

                        navController =
                            navController,

                        container =
                            container,

                        padding =
                            padding
                    )
                }
            }
        }
    }
}