package com.handongwook.harry_potter.core.network.service

import com.handongwook.harry_potter.core.network.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: String): List<CharacterResponse>
}