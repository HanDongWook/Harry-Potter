package com.handongwook.harry_potter.feature.characters

import androidx.compose.runtime.Stable
import com.handongwook.core_model.model.Character

@Stable
data class CharactersUiState(
    val characters: List<Character> = emptyList()
)
