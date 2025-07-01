package com.handongwook.harry_potter.ui.characters

import androidx.compose.runtime.Stable

@Stable
data class CharactersSideEffect(
    val list: List<String> = emptyList()
)
