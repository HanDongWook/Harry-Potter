package com.handongwook.core_database.di

import androidx.room.Room
import com.handongwook.core_database.HarryPotterDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room
            .databaseBuilder(
                androidApplication(),
                HarryPotterDatabase::class.java,
                "HarryPotter.db"
            )
            .build()
    }
}