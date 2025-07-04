package com.handongwook.harry_potter

import android.app.Application
import com.handongwook.harry_potter.di.appModule
import com.handongwook.harry_potter.feature.characters.di.charactersModule
import com.handongwook.harry_potter.feature.details.di.detailsModule
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

            //feature
            modules(charactersModule)
            modules(detailsModule)
        }
    }
}
