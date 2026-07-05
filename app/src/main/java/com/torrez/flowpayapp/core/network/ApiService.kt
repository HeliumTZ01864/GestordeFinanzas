package com.torrez.flowpayapp.core.network

import com.torrez.flowpayapp.data.remote.dto.ApiResponse
import com.torrez.flowpayapp.data.remote.dto.CreateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UpdateUserRequest
import com.torrez.flowpayapp.data.remote.dto.UserDataDto
import com.torrez.flowpayapp.data.remote.dto.UserDetailResponse
import com.torrez.flowpayapp.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("usuarios")
    suspend fun obtenerUsuarios(): Response<ApiResponse<UserDataDto>>

    @GET("usuarios/{id}")
    suspend fun getUsuarioById(
        @Path("id") id: String
    ): Response<UserDetailResponse>

    @POST("usuarios")
    suspend fun insertarUsuario(
        @Body request: CreateUserRequest
    ): Response<UserDto>

    @PUT("usuarios/{id}")
    suspend fun actualizarUsuario(
        @Path("id") id: String,
        @Body request: UpdateUserRequest
    ): Response<UserDto>

    @DELETE("usuarios/{id}")
    suspend fun eliminiarUsuario(
        @Path("id") id: String
    ): Response<Unit>
}