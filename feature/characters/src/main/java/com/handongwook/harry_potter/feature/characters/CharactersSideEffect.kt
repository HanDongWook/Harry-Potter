package com.handongwook.harry_potter.feature.characters

import androidx.compose.runtime.Stable

@Stable
sealed interface CharactersSideEffect {
    data class NavigateToDetail(val characterId: String) : CharactersSideEffect
}
