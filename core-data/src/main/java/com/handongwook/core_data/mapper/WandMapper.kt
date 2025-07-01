package com.handongwook.core_data.mapper

import com.handongwook.core_model.model.Wand
import com.handongwook.core_network.model.WandResponse

fun WandResponse.toDomain(): Wand {
    return Wand(
        wood = wood,
        core = core,
        length = length
    )
}