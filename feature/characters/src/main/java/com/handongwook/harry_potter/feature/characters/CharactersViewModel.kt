package com.handongwook.harry_potter.feature.characters

import androidx.lifecycle.ViewModel
import com.handongwook.core_data.repository.character.CharacterRepository
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class CharactersViewModel(
    private val characterRepository: CharacterRepository
): ViewModel(), ContainerHost<CharactersUiState, CharactersSideEffect> {

    override val container: Container<CharactersUiState, CharactersSideEffect> =
        container(initialState = CharactersUiState()) {
            val characters = characterRepository.getCharacters()
            reduce {
                state.copy(
                    characters = characters
                )
            }
        }

    fun fetchNextItems() {

    }

    fun onCharacterClick() {

    }
}