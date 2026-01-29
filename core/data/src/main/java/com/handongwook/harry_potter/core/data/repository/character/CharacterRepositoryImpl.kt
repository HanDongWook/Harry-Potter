package com.handongwook.harry_potter.core.data.repository.character

import com.handongwook.harry_potter.core.data.mapper.toDomain
import com.handongwook.harry_potter.core.model.Character
import com.handongwook.harry_potter.core.network.service.CharacterService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
    private val ioDispatcher: CoroutineDispatcher
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> = withContext(ioDispatcher) {
        Timber.e("getCharacters")
        val characters = characterService.getCharacters()
        Timber.e("characters.size:${characters.size}")
        return@withContext characters.map { it.toDomain() }
    }

    override suspend fun getCharacterById(id: String): Character = withContext(ioDispatcher) {
        Timber.e("getCharacterById id:$id")
        val characters = characterService.getCharacterById(id)
        if (characters.isEmpty()) {
            throw Exception("Character not found")
        }
        Timber.d("getCharacterById: ${characters.first().name}")
        return@withContext characters.first().toDomain()
    }
}