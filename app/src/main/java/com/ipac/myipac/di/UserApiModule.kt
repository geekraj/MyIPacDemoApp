package com.ipac.myipac.di

import com.ipac.myipac.service.UsersApi
import org.koin.dsl.module
import retrofit2.Retrofit

val userApiModule = module {
    fun provideCountriesApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }
    single { provideCountriesApi(get()) }
}