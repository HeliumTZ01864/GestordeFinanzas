package com.torrez.flowpayapp

import android.app.Application
import com.torrez.flowpayapp.di.AppContainer

class FlowAplication : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
    }
}