package com.torrez.flowpayapp.data.remote.dto

data class UserDataDto(
    val items: List<UserDto>,
    val nextKey: String?
)
