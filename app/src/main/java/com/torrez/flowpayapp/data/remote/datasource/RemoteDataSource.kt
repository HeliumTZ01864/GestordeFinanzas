package com.torrez.flowpayapp.data.remote.datasource

import com.torrez.flowpayapp.core.network.ApiService
import com.torrez.flowpayapp.data.remote.dto.ApiResponse
import com.torrez.flowpayapp.data.remote.dto.CreateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UpdateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UserDataDto
import com.torrez.flowpayapp.data.remote.dto.UserDetailResponse
import com.torrez.flowpayapp.data.remote.dto.UserDto

class RemoteDataSource (private val api: ApiService){

    suspend fun getUsers(): ApiResponse <UserDataDto>?{
        return api.obtenerUsuarios().body()
    }

    suspend fun getUserById(id: String): UserDto? {
        return api.getUsuarioById(id).body()?.data
    }

    suspend fun createUser(createUserRequest: CreateUserRequest): UserDto? {
        return api.insertarUsuario(createUserRequest).body()
    }

    suspend fun updateUser(id: String,updateUserRequest: UpdateUserRequest): UserDto?{
        return api.actualizarUsuario(id,updateUserRequest).body()
    }

    suspend fun deleteUser(id: String){
        api.eliminiarUsuario(id)
    }

}