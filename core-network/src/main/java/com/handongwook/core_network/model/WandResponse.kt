package com.handongwook.core_network.model

import kotlinx.serialization.Serializable

@Serializable
data class WandResponse(
    val wood: String,
    val core: String,
    val length: Double?
)