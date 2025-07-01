package com.handongwook.harry_potter

import android.app.Application
import com.handongwook.core_data.di.dataModule
import com.handongwook.core_network.di.dispatchersModule
import com.handongwook.core_network.di.networkModule
import com.handongwook.harry_potter.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class HarryPotterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HarryPotterApp)
            androidLogger(Level.DEBUG)
            modules(appModule)
            modules(dataModule)
            modules(networkModule)
            modules(dispatchersModule)
        }
    }
}
