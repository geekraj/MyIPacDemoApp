package com.ipac.myipac.repository

import android.content.Context
import android.util.Log
import com.ipac.myipac.db.UserDao
import com.ipac.myipac.db.model.Result
import com.ipac.myipac.db.model.UserResponse
import com.ipac.myipac.service.UsersApi
import com.ipac.myipac.util.ApiResult
import com.ipac.myipac.util.NetworkManager.isOnline
import com.ipac.myipac.util.TAG
import com.ipac.myipac.util.Utils.handleApiError
import com.ipac.myipac.util.Utils.handleSuccess
import com.ipac.myipac.util.noNetworkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersRepositoryImpl(
    private val api: UsersApi,
    private val context: Context,
    private val dao: UserDao,
    private var userResponse: UserResponse
) : UsersRepository {
    override suspend fun getUsers(result: Int): ApiResult<UserResponse> {
        if (isOnline(context)) {
            return try {
                val response = api.getUsers(result)
                if (response.isSuccessful) {
                    //save the data
                    response.body()?.let {
                        withContext(Dispatchers.IO) { dao.add(it.results) }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                ApiResult.Error(e)
            }
        } else {
            //check in db if the data exists
            val data = getCountriesDataFromCache()
            return if (data.isNotEmpty()) {
                Log.d(TAG, "from db")
                userResponse.results = data
                ApiResult.Success(userResponse)
            } else
            //no network
                context.noNetworkConnectivityError()
        }
    }
    private suspend fun getCountriesDataFromCache(): List<Result> {
        return withContext(Dispatchers.IO) {
            dao.getUsers()
        }
    }

}