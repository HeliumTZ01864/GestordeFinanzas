package com.torrez.flowpayapp.data.remote.dto

data class ApiResponse<T>(
    val success: Boolean,
    val data: T,
    val timestamp: String
)
