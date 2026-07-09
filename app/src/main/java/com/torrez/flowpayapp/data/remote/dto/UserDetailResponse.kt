package com.torrez.flowpayapp.data.remote.dto

data class UserDetailResponse(
    val success: Boolean,
    val data: UserDto,
    val timestamp: String
)
