package com.ipac.myipac.di

import android.content.Context
import com.ipac.myipac.db.UserDao
import com.ipac.myipac.db.model.UserResponse
import com.ipac.myipac.repository.UsersRepository
import com.ipac.myipac.repository.UsersRepositoryImpl
import com.ipac.myipac.service.UsersApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { UserResponse() }
    fun provideCountryRepository(
        api: UsersApi,
        context: Context,
        dao: UserDao,
        userResponse: UserResponse
    ): UsersRepository {
        return UsersRepositoryImpl(api, context, dao, userResponse)
    }
    single { provideCountryRepository(get(), androidContext(), get(), get()) }
}