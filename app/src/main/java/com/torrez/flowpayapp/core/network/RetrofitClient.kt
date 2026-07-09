package com.torrez.flowpayapp.core.network

import com.torrez.flowpayapp.core.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.USER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}