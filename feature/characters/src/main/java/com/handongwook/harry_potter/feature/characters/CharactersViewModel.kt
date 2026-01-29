package com.handongwook.harry_potter.feature.characters

import com.handongwook.harry_potter.core.viewmodel.BaseViewModel
import com.handongwook.harry_potter.core.data.repository.character.CharacterRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class CharactersViewModel(
    coroutineExceptionHandler: CoroutineExceptionHandler,
    private val characterRepository: CharacterRepository
) : BaseViewModel(coroutineExceptionHandler),
    ContainerHost<CharactersUiState, CharactersSideEffect> {

    override val container: Container<CharactersUiState, CharactersSideEffect> =
        container(initialState = CharactersUiState()) {
            fetchCharacters()
        }

    private fun fetchCharacters() = intent {
        viewModelErrorHandlingScope.launch {
            val characters = characterRepository.getCharacters()
            reduce {
                state.copy(
                    characters = characters
                )
            }
        }
    }

    fun fetchNextCharacters() {

    }

    fun onCharacterClick(characterId: String) = intent {
        postSideEffect(CharactersSideEffect.NavigateToDetail(characterId))
    }
}