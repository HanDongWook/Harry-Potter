package com.handongwook.core_data.repository.character

import com.handongwook.core_data.mapper.toDomain
import com.handongwook.core_model.model.Character
import com.handongwook.core_network.service.CharacterService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
    private val ioDispatcher: CoroutineDispatcher
): CharacterRepository {
    override suspend fun getCharacters(): List<Character> = withContext(ioDispatcher) {
        val characters = characterService.getCharacters()
        Timber.e("characters.size:${characters.size}")
        return@withContext characters.map { it.toDomain() }
    }
}