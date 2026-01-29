package com.handongwook.harry_potter.core.network.service

import com.handongwook.harry_potter.core.network.model.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>
}