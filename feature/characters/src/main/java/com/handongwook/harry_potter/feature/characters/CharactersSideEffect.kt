package com.handongwook.harry_potter.feature.characters

import androidx.compose.runtime.Stable

@Stable
data class CharactersSideEffect(
    val list: List<String> = emptyList()
)
