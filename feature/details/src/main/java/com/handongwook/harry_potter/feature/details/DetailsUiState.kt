package com.handongwook.harry_potter.feature.details

import com.handongwook.harry_potter.core.model.Character

data class DetailsUiState(
    val character: Character? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
