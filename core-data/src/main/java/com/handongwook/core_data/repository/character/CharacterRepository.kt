package com.handongwook.core_data.repository.character

import com.handongwook.core_model.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}