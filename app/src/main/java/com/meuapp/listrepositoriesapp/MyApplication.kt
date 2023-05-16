package com.meuapp.listrepositoriesapp

import android.app.Application
import com.meuapp.listrepositoriesapp.di.dataSourceModules
import com.meuapp.listrepositoriesapp.di.repositoriesModules
import com.meuapp.listrepositoriesapp.di.useCaseModules
import com.meuapp.listrepositoriesapp.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                useCaseModules,
                repositoriesModules,
                dataSourceModules,
                viewModelModules
            ).androidContext(applicationContext)
        }
    }
}