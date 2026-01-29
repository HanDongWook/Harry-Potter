package com.handongwook.harry_potter.data.repository.character

import com.handongwook.harry_potter.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}