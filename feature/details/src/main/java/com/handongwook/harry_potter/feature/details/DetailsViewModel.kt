package com.handongwook.harry_potter.feature.details

import com.handongwook.harry_potter.core.data.repository.character.CharacterRepository
import com.handongwook.harry_potter.core.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber

class DetailsViewModel(
    coroutineExceptionHandler: CoroutineExceptionHandler,
    private val characterRepository: CharacterRepository
) : BaseViewModel(coroutineExceptionHandler),
    ContainerHost<DetailsUiState, DetailsSideEffect> {

    override val container: Container<DetailsUiState, DetailsSideEffect> =
        container(initialState = DetailsUiState())

    fun fetchCharacterDetail(characterId: String) = intent {
        Timber.d("fetchCharacterDetail started for id: $characterId")
        reduce { state.copy(isLoading = true) }
        
        viewModelErrorHandlingScope.launch {
            try {
                val character = characterRepository.getCharacterById(characterId)
                Timber.d("Character fetched successfully: ${character.name}")
                reduce {
                    state.copy(
                        character = character,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                Timber.e(e, "Error fetching character details for id: $characterId")
                reduce {
                    state.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown error occurred"
                    )
                }
            }
        }
    }

    fun onBackClick() = intent {
        postSideEffect(DetailsSideEffect.NavigateBack)
    }
}
