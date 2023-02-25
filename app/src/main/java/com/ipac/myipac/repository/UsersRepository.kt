package com.ipac.myipac.repository

import com.ipac.myipac.db.model.UserResponse
import com.ipac.myipac.util.ApiResult

interface UsersRepository {
    suspend fun getUsers(result: Int) : ApiResult<UserResponse>
}