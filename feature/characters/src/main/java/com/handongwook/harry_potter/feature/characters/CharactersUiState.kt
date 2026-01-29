package com.handongwook.harry_potter.feature.characters

import androidx.compose.runtime.Stable
import com.handongwook.harry_potter.model.Character

@Stable
data class CharactersUiState(
    val characters: List<Character> = emptyList()
)
