package com.handongwook.harry_potter.core.data.repository.character

import com.handongwook.harry_potter.core.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}