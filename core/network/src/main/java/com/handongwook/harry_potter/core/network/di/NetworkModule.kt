package com.handongwook.harry_potter.core.network.di

import com.handongwook.harry_potter.core.network.BuildConfig
import com.handongwook.harry_potter.core.network.service.CharacterService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

val networkModule = module {
    single {
        Json {
            ignoreUnknownKeys = true
        }
    }

    single {
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(get<Json>().asConverterFactory("application/json".toMediaType()))
            .client(get<OkHttpClient>())
            .build()
    }

    single {
        get<Retrofit>().create(CharacterService::class.java)
    }
}