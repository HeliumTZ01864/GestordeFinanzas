package com.torrez.flowpayapp.data.remote.datasource

import com.torrez.flowpayapp.data.remote.dto.CreateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UpdateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UserDataDto
import com.torrez.flowpayapp.data.remote.dto.UserDetailResponse

interface RemoteDataSource {

    suspend fun getUsers(): UserDataDto

    suspend fun getUserById(id: String): UserDetailResponse

    suspend fun createUser(createUserRequest: CreateUserRequest)

    suspend fun updateUser(id: String,updateUserRequest: UpdateUserRequest)

    suspend fun deleteUser(id: String)

}