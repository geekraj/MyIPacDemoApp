package com.ipac.myipac.service

import com.ipac.myipac.db.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApi {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int): Response<UserResponse>
}