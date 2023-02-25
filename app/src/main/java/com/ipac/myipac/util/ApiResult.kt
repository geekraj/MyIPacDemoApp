package com.ipac.myipac.util

sealed class ApiResult<out T> {

    data class Success<out T>(val successData : T) : ApiResult<T>()
    class Error(val exception: java.lang.Exception, val message: String = exception.localizedMessage)
        : ApiResult<Nothing>()

}