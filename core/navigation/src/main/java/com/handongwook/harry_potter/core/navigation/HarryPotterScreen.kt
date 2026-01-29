package com.handongwook.harry_potter.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Characters : NavKey

@Serializable
data class Details(val characterId: String) : NavKey