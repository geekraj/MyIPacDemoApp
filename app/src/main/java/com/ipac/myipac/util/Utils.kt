package com.ipac.myipac.util

import retrofit2.Response

object Utils {
    fun <T : Any> handleApiError(resp: Response<T>): ApiResult.Error {
        val error = ApiErrorUtils.parseError(resp)
        return ApiResult.Error(Exception(error.message))
    }

    fun <T : Any> handleSuccess(response: Response<T>): ApiResult<T> {
        response.body()?.let {
            return ApiResult.Success(it)
        } ?: return handleApiError(response)
    }
}