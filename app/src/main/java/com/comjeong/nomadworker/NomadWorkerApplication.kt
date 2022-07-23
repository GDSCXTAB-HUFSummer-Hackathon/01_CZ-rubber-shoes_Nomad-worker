package com.comjeong.nomadworker

import android.app.Application
import com.comjeong.nomadworker.data.datasource.local.NomadSharedPreferences
import com.comjeong.nomadworker.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class NomadWorkerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NomadWorkerApplication)
            modules(networkModule, repositoryModule, viewModelModule, dataSourceModule)
        }

        NomadSharedPreferences.init(applicationContext)

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }
}