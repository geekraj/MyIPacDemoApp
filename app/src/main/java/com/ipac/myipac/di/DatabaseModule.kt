package com.ipac.myipac.di


import android.app.Application
import androidx.room.Room
import com.ipac.myipac.db.UserDao
import com.ipac.myipac.db.UsersDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): UsersDatabase {
        return Room.databaseBuilder(application, UsersDatabase::class.java, "Users")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountriesDao(database: UsersDatabase): UserDao {
        return database.userDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }


}