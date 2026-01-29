package com.handongwook.harry_potter.feature.details

import androidx.compose.runtime.Stable

@Stable
sealed interface DetailsSideEffect {
    data object NavigateBack : DetailsSideEffect
}
