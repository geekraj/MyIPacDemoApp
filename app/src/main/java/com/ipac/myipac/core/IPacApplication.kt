package com.ipac.myipac.core

import android.app.Application
import com.ipac.myipac.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IPacApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@IPacApplication)
            modules(
                userApiModule,
                networkModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            )
        }
    }
}