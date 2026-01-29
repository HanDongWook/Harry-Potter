package com.handongwook.harry_potter.data.repository.character

import com.handongwook.harry_potter.data.mapper.toDomain
import com.handongwook.harry_potter.model.Character
import com.handongwook.harry_potter.network.service.CharacterService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> = withContext(ioDispatcher) {
        val characters = characterService.getCharacters()
        Timber.e("characters.size:${characters.size}")
        return@withContext characters.map { it.toDomain() }
    }
}