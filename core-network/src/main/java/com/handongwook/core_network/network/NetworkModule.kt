package com.handongwook.core_network.network

import com.handongwook.core_network.BuildConfig
import com.handongwook.core_network.service.CharacterService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        Json {
           ignoreUnknownKeys = true
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
            .client(get<OkHttpClient>()) // 위에서 정의한 OkHttpClient 주입
            .build()
    }

    single {
        get<Retrofit>().create(CharacterService::class.java)
    }
}