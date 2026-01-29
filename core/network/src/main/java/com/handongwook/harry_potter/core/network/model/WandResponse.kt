package com.handongwook.harry_potter.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class WandResponse(
    val wood: String,
    val core: String,
    val length: Double?
)