package com.handongwook.core_network.service

import com.handongwook.core_network.model.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>
}