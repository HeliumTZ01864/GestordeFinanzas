package com.torrez.flowpayapp.di

import com.torrez.flowpayapp.core.network.ApiService
import com.torrez.flowpayapp.core.network.RetrofitClient

class NetworkModule {
    val apiService: ApiService by lazy {
        RetrofitClient.api
    }
}